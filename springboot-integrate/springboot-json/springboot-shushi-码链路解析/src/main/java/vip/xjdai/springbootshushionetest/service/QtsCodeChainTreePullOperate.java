package vip.xjdai.springbootshushionetest.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.curator.shaded.com.google.common.collect.Sets;
import org.springframework.util.CollectionUtils;
import pro.shushi.pamirs.meta.common.exception.PamirsException;
import vip.xjdai.springbootshushionetest.enums.*;
import vip.xjdai.springbootshushionetest.model.QtsCodeChainEipModel;
import vip.xjdai.springbootshushionetest.model.QtsCodeChainTreeEipModel;
import vip.xjdai.springbootshushionetest.model.QtsCodeProductInfo;
import vip.xjdai.springbootshushionetest.utils.JSONUtisl;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 码链路处理
 */
public class QtsCodeChainTreePullOperate {

    /**
     * 数量解析, 加上了产品规格 ，新的解析方法..
     *
     * @param chainTreeEipModels
     */
    public void dealChainTreeEipModelNew(List<QtsCodeChainTreeEipModel> chainTreeEipModels) {

        Map<String, QtsCodeProductInfo> productMaps = checkData(chainTreeEipModels);
        // 3. 获取产品信息
        // List<QtsProductInventory> qtsProductInventories = queryProductSKU(productMaps);
        // 4. 获取系列名称
        handleCore(chainTreeEipModels, productMaps);
        //  过滤异常数据
        chainTreeEipModels = filterErrorData(chainTreeEipModels, productMaps);
        //  解析进行判断，设置数量的计算方式
        setCalculation(chainTreeEipModels);
        //  补齐信息...
        setQuantityAnalysis(chainTreeEipModels, productMaps);
        //  更新 or 新增
        updateOrSave(productMaps);
    }

    private void handleCore(List<QtsCodeChainTreeEipModel> chainTreeEipModels, Map<String, QtsCodeProductInfo> productMaps) {
        // 去递归获取值，然后返回做判断
        for (QtsCodeChainTreeEipModel chainTreeEipModel : chainTreeEipModels) {
            QtsCodeChainEipModel relationTree = chainTreeEipModel.getRelationTree();
            //  获取最外层的大箱
            getPackage(relationTree, productMaps);
            // 给数据打标机
            boolean mark = mark(relationTree);
            chainTreeEipModel.setIsError(mark);
        }
    }

    private void updateOrSave(Map<String, QtsCodeProductInfo> productMaps) {
        List<QtsCodeProductInfo> list = new ArrayList<>(productMaps.size());
        for (Map.Entry<String, QtsCodeProductInfo> entry : productMaps.entrySet()) {
            list.add(entry.getValue());
        }
        qtsCodeProductInfoService.create(list);
    }

    /**
     * 设置数量，解析状态
     *
     * @return QtsCodeProductInfo
     */
    private void setQuantityAnalysis(List<QtsCodeChainTreeEipModel> chainTreeEipModels, Map<String, QtsCodeProductInfo> productMaps) {
        for (QtsCodeChainTreeEipModel chainTreeEipModel : chainTreeEipModels) {
            QtsCodeChainEipModel relationTree = chainTreeEipModel.getRelationTree();
            setData(relationTree, productMaps);
            forSet(relationTree, productMaps);
        }
    }

    /**
     * 递归设置值
     *
     * @param relationTree
     * @param productMaps
     */
    private void forSet(QtsCodeChainEipModel relationTree, Map<String, QtsCodeProductInfo> productMaps) {
        if (CollectionUtils.isEmpty(relationTree.getChildrens())) {
            return;
        }
        for (QtsCodeChainEipModel children : relationTree.getChildrens()) {
            setData(children, productMaps);
            forSet(children, productMaps);
        }
    }

    /**
     * 补充 码产品信息
     *
     * @param relationTree
     * @param productMaps
     */
    private void setData(QtsCodeChainEipModel relationTree, Map<String, QtsCodeProductInfo> productMaps) {
        QtsCodeProductInfo codeProductInfo = productMaps.get(relationTree.getCurrentId().toString());
        if (codeProductInfo != null) {
            // 69码
            codeProductInfo.setBarCode(relationTree.getBarCode());
            // 包装数量
            codeProductInfo.setQuantity(relationTree.getQuantity());
            // 首次包装数量 ? TODO
            codeProductInfo.setFirstQuantity(relationTree.getQuantity());
            // 设置状态
            CodeAnalysisStatusEnum enumByValue = CodeAnalysisStatusEnum.getEnumByValue(CodeAnalysisStatusEnum.class, relationTree.getAnalysisStatus());
            codeProductInfo.setAnalysisStatus(enumByValue);
            // 0=上层补齐， 1=出厂自带
            codeProductInfo.setRepairedBarcodeStatus(RepairedBarcodeStatusEnum.getEnumByValue(RepairedBarcodeStatusEnum.class, relationTree.getIsComplement() ? 0 : 1));
            // 是否存在规格表中
            codeProductInfo.setExistInSpec(ExistInSpecEnum.getEnumByValue(ExistInSpecEnum.class, relationTree.getExistInSpec() != null && relationTree.getExistInSpec() == 1 ? 1 : 0));
            //  包装结构
            codeProductInfo.setPackagingStructure(CodeMarkTypeEnum.getEnumByValue(CodeMarkTypeEnum.class, relationTree.getPackageType()));
            //产品编码
            codeProductInfo.setBindSkuCode(relationTree.getBindSkuCode());
            //产品名称
            codeProductInfo.setBindSkuName(relationTree.getBindSkuName());
            //  将产品信息补给码产品信息？
            // --------------------------查询：系列表----------------------------
            //  将系列编码也补齐
            //  productInfo.setSeriesCode(libraItemSeries.getCode());
            //  将系列名称也补齐
            //  productInfo.setSeriesName(libraItemSeries.getName());
            // -----------------------------------------------------------------
            // --------------------------查询：产品表---------------------------
            //系列名称
            // if (StringUtils.isEmpty(codeProductInfo.getSeriesName())) {
            //    codeProductInfo.setSeriesName(productSku.getSeriesName());
            // }
            //            //英文名
            //            if (StringUtils.isEmpty(productInfo.getEnName())) {
            //                codeProductInfo.setEnName(productSku.getEnName());
            //            }
        }
    }


    /**
     * 设置计算方式
     *  TODO 先把流程跑通后，会进行代码的优化
     *
     * @param chainTreeEipModels
     */
    private void setCalculation(List<QtsCodeChainTreeEipModel> chainTreeEipModels) {
        // 如果是 大中、大小、小，直接去计算
        for (QtsCodeChainTreeEipModel chainTreeEipModel : chainTreeEipModels) {
            QtsCodeChainEipModel relationTree = chainTreeEipModel.getRelationTree();
            relationTree.setAnalysisStatus(CodeAnalysisStatusEnum.ANALYSIS_SUCCESS.value());
            CodeMarkTypeEnum packageType = CodeMarkTypeEnum.getEnumByValue(CodeMarkTypeEnum.class, relationTree.getPackageType());
            // 单独小盒结构，需要数据支持
            if (CodeMarkTypeEnum.ROD.equals(packageType) || CodeMarkTypeEnum.CARTRIDGE.equals(packageType)) {
                smallTwo(relationTree);
            }
            // 大小处理
            if (CodeMarkTypeEnum.BIG_SMALL_CARTRIDGE.equals(packageType) || CodeMarkTypeEnum.BIG_ROD.equals(packageType)) {
                // 大箱中的数量 = 小箱数量的求和
                relationTree.setQuantity(new BigDecimal(0)); // 大盒数量
                bigSmall(relationTree);
            }
            // 大中处理
            if (CodeMarkTypeEnum.BIG_MID.equals(packageType) || CodeMarkTypeEnum.BIG_MID_CARTRIDGE.equals(packageType)) {
                // 大箱中的数量= 数量中箱的求和
                relationTree.setQuantity(new BigDecimal(0));
                mid(relationTree);
            }
            // 大中小计算
            if (CodeMarkTypeEnum.BIG_MID_ROD.equals(packageType) || CodeMarkTypeEnum.BIG_MID_SMALL_CARTRIDGE.equals(packageType)) {
                // 大箱中的数量 = 数量中箱的求和 或者 小箱的求和
                BigDecimal count = new BigDecimal("0");
                relationTree.setQuantity(new BigDecimal(0)); // 大盒数量
                bigMidSmall(relationTree, count, relationTree.getCalculationMode());
            }
        }
    }

    /**
     * @param relationTree
     * @param count
     * @return
     */
    private BigDecimal bigMidSmall(QtsCodeChainEipModel relationTree, BigDecimal count, Boolean specialProducts) {
        List<QtsCodeChainEipModel> childrens = relationTree.getChildrens();
        if (CollectionUtils.isEmpty(childrens)) {
            return count;
        }
        for (QtsCodeChainEipModel children : childrens) {
            children.setExistInSpec(relationTree.getCodeTypeEnum());
            CodeTypeEnum codeType = CodeTypeEnum.getEnumByValue(CodeTypeEnum.class, children.getCodeTypeEnum());
            if (specialProducts) {
                if (CodeTypeEnum.ROD.equals(codeType) || CodeTypeEnum.SMALL.equals(codeType)) {
                    count = count.add(new BigDecimal(1));
                    setanalysisSuccess(children);
                    if (!CollectionUtils.isEmpty(children.getChildrens())) {
                        for (QtsCodeChainEipModel childrenChildren : children.getChildrens()) {
                            setAnalysisSuccessLimited(childrenChildren);
                        }
                    }
                }
                BigDecimal bigDecimal = bigMidSmall(children, count, specialProducts);
                if (CodeTypeEnum.MID.equals(codeType)) {
                    children.setQuantity(new BigDecimal(0).add(bigDecimal));
                    relationTree.setQuantity(relationTree.getQuantity().add(children.getQuantity()));
                    children.setAnalysisStatus(CodeAnalysisStatusEnum.ANALYSIS_SUCCESS.value());
                }
            } else {
                // 如果是中箱的话
                if (CodeTypeEnum.MID.equals(codeType)) {
                    setanalysisSuccess(children);
                    relationTree.setQuantity(relationTree.getQuantity().add(children.getQuantity()));
                } else {
                    setAnalysisSuccessLimited(children);
                }
                bigMidSmall(children, count, specialProducts);
            }
        }
        return count;
    }

    /**
     * 设置不能解析的
     *
     * @param children
     */
    private void setAnalysisSuccessLimited(QtsCodeChainEipModel children) {
        children.setQuantity(new BigDecimal(1));
        children.setAnalysisStatus(CodeAnalysisStatusEnum.ANALYSIS_SUCCESS_LIMITED.value());
    }

    /**
     * 成功的设置值
     *
     * @param children
     */
    private void setanalysisSuccess(QtsCodeChainEipModel children) {
        children.setQuantity(new BigDecimal(1));
        children.setAnalysisStatus(CodeAnalysisStatusEnum.ANALYSIS_SUCCESS.value());
    }

    /**
     * 大 中计算
     *
     * @param relationTree
     */
    private void mid(QtsCodeChainEipModel relationTree) {
        List<QtsCodeChainEipModel> childrens = relationTree.getChildrens();
        if (CollectionUtils.isEmpty(childrens)) {
            return;
        }
        for (QtsCodeChainEipModel children : childrens) {
            CodeTypeEnum enumByValue = CodeTypeEnum.getEnumByValue(CodeTypeEnum.class, children.getCodeTypeEnum());
            // 如果是 中箱的话
            if (CodeTypeEnum.MID.equals(enumByValue)) {
                setanalysisSuccess(children);
                relationTree.setQuantity(relationTree.getQuantity().add(children.getQuantity()));
            } else {
                setAnalysisSuccessLimited(children);
            }
            mid(children);
        }
    }

    /**
     * @param relationTree
     * @return
     */
    private void bigSmall(QtsCodeChainEipModel relationTree) {
        List<QtsCodeChainEipModel> childrens = relationTree.getChildrens();
        if (CollectionUtils.isEmpty(relationTree.getChildrens())) {
            return;
        }
        for (QtsCodeChainEipModel children : childrens) {
            CodeTypeEnum enumByValue = CodeTypeEnum.getEnumByValue(CodeTypeEnum.class, children.getCodeTypeEnum());
            // 如果是 烟杆 或者是 小盒 的话
            if (CodeTypeEnum.ROD.equals(enumByValue) || CodeTypeEnum.SMALL.equals(enumByValue)) {
                setanalysisSuccess(children);
                relationTree.setQuantity(relationTree.getQuantity().add(new BigDecimal(1)));
            } else {
                // 烟弹处理
                setAnalysisSuccessLimited(children);
            }
            bigSmall(children);
        }
    }


    /**
     * 计算包装数量
     */
    private void smallTwo(QtsCodeChainEipModel relationTree) {
        // 设置包装数量
        setanalysisSuccess(relationTree);
        if (relationTree != null && !CollectionUtils.isEmpty(relationTree.getChildrens())) {
            // 如果有下层结构，那么可以认为是烟弹
            List<QtsCodeChainEipModel> childrens = relationTree.getChildrens();
            for (QtsCodeChainEipModel children : childrens) {
                setAnalysisSuccessLimited(children);
            }
        }
    }


    /**
     * 过滤异常数据
     *
     * @param chainTreeEipModels
     * @param productMaps
     * @return
     */
    private List<QtsCodeChainTreeEipModel> filterErrorData(List<QtsCodeChainTreeEipModel> chainTreeEipModels, Map<String, QtsCodeProductInfo> productMaps) {
        return chainTreeEipModels.stream().filter(item -> {
            // 过滤下错误数据
            if (item.getIsError()) {
                //  处理异常数据
                QtsCodeChainEipModel children = item.getRelationTree();
                children.setAnalysisStatus(CodeAnalysisStatusEnum.ANALYSIS_EX_BARCODE.value());
                CodeMarkTypeEnum enumByValue = CodeMarkTypeEnum.getEnumByValue(CodeMarkTypeEnum.class, children.getPackageType());
                children.setAnalysisErrReason(enumByValue.displayName() + "69码不一致");
                setData(children, productMaps);
                createErrorData(item.getRelationTree(), productMaps);
                return false;
            }
            return true;
        }).collect(Collectors.toList());


    }

    /**
     * 对错数据进行一个记录，插入到表中，不进行后续的计算
     *
     * @param parentChain
     * @param productMaps
     */
    private void createErrorData(QtsCodeChainEipModel parentChain, Map<String, QtsCodeProductInfo> productMaps) {
        if (CollectionUtils.isEmpty(parentChain.getChildrens())) {
            return;
        }
        for (QtsCodeChainEipModel children : parentChain.getChildrens()) {
            children.setAnalysisStatus(CodeAnalysisStatusEnum.ANALYSIS_EX_BARCODE.value());
            CodeMarkTypeEnum enumByValue = CodeMarkTypeEnum.getEnumByValue(CodeMarkTypeEnum.class, children.getPackageType());
            children.setAnalysisErrReason(enumByValue.displayName() + "69码不一致");
            setData(children, productMaps);
            createErrorData(children, productMaps);
        }
    }

    /**
     * <br/>1. 将所有数据进行循环
     * <br/>2. 对数据进行补码操作，包括（产品编码、69码、是否补码、包装类型进行填充）
     * <br/>3. 获取包装结构，主要目的
     *
     * @param relationTree
     * @param productMap
     */
    private void getPackage(QtsCodeChainEipModel relationTree, Map<String, QtsCodeProductInfo> productMap) {
        // 获取对应的码产品数据
        QtsCodeProductInfo qtsCodeProductInfo = productMap.get(relationTree.getCurrentId().toString());
        relationTree.setBarCode(qtsCodeProductInfo.getBarCode());
        relationTree.setCodeTypeEnum(qtsCodeProductInfo.getCodeType().value());
        relationTree.setIsComplement(false);
        relationTree.setBindSkuCode(qtsCodeProductInfo.getBindSkuCode());
        relationTree.setBindSkuName(qtsCodeProductInfo.getBindSkuName());
        Set<Integer> codeTypeEnums = Sets.newHashSet();
        codeTypeEnums.add(qtsCodeProductInfo.getCodeType().value());
        // 递归获取枚举，设置值..
        getPackage(relationTree, productMap, codeTypeEnums);
        Integer integer = convertDepth(codeTypeEnums);
        // 获取枚举值
        relationTree.setPackageType(integer);
    }


    /**
     * 处理枚举，补齐信息
     *
     * @param parentEipMode
     * @param productMap
     * @param list
     */
    private void getPackage(QtsCodeChainEipModel parentEipMode, Map<String
            , QtsCodeProductInfo> productMap, Set<Integer> list) {
        if (CollectionUtils.isEmpty(parentEipMode.getChildrens())) {
            return;
        }
        for (QtsCodeChainEipModel children : parentEipMode.getChildrens()) {
            QtsCodeProductInfo childrenProduct = productMap.get(children.getCurrentId().toString());
            if (StringUtils.isBlank(childrenProduct.getBarCode())) {
                // 设置为补码
                children.setIsComplement(true);
                children.setBarCode(parentEipMode.getBarCode());
                children.setBindSkuName(parentEipMode.getBindSkuName());
                children.setBindSkuCode(parentEipMode.getBindSkuCode());
            } else {
                children.setIsComplement(false);
                children.setBarCode(childrenProduct.getBarCode());
                children.setBindSkuName(childrenProduct.getBindSkuName());
                children.setBindSkuCode(childrenProduct.getBindSkuCode());
            }
            children.setCodeTypeEnum(childrenProduct.getCodeType().value());
            list.add(children.getCodeTypeEnum());
            getPackage(children, productMap, list);
        }
    }


    /**
     * 处理枚举值，进行拼接
     *
     * @return
     */
    private Integer convertDepth(Set<Integer> codeTypeEnums) {
        TreeSet<Integer> ts = new TreeSet<>(codeTypeEnums);
        StringBuilder s = new StringBuilder();
        for (Integer t : ts) {
            s.append(t);
        }
        return Integer.valueOf(s.toString());
    }


    /**
     * <br/>1. 给数据打标机
     * <br/>2. 设置没一条数据的包装结构.
     *
     * @param relationTree 大箱集合数据
     * @return
     */
    private boolean mark(QtsCodeChainEipModel relationTree) {
        Map<Integer, CalculationEnum> calculationEnumBooleanMap = Maps.newHashMap();
        // 开始递归打标
        packageData(relationTree, calculationEnumBooleanMap);
        CalculationEnum upIsInconsistent = calculationEnumBooleanMap.get(CalculationEnum.UP_IS_INCONSISTENT.value());
        CalculationEnum specialProducts = calculationEnumBooleanMap.get(CalculationEnum.SPECIAL_PRODUCTS.value());
        // upIsInconsistent 是 null 证明全一致
        // specialProducts  为补码数据
        if (upIsInconsistent == null && specialProducts != null) {
            if (qtsSpecialProductQueryService.queryByBarCode(relationTree.getBarCode()) != null) {
                relationTree.setCalculationMode(true);
                relationTree.setExistInSpec(1);
            } else {
                relationTree.setCalculationMode(false);
            }
        } else relationTree.setCalculationMode(upIsInconsistent == null && specialProducts == null);
        return calculationEnumBooleanMap.get(CalculationEnum.IS_ERROR.value()) != null;
    }

    /**
     * @param parentEipModel 当前节点
     */
    private static void packageData(QtsCodeChainEipModel parentEipModel, Map<Integer, CalculationEnum> integerCalculationEnumMap) {
        List<QtsCodeChainEipModel> childrens = parentEipModel.getChildrens();
        if (!CollectionUtils.isEmpty(childrens)) {
            for (QtsCodeChainEipModel children : childrens) {
                //  设置包装类型
                children.setPackageType(parentEipModel.getPackageType());
                //  父级枚举
                CodeTypeEnum parenCodeType = CodeTypeEnum.getEnumByValue(CodeTypeEnum.class, parentEipModel.getCodeTypeEnum());
                //  子级枚举
                CodeTypeEnum sonCodeType = CodeTypeEnum.getEnumByValue(CodeTypeEnum.class, children.getCodeTypeEnum());
                if (children.getIsComplement()) {
                    integerCalculationEnumMap.put(CalculationEnum.SPECIAL_PRODUCTS.value(), CalculationEnum.SPECIAL_PRODUCTS);
                }
                // 存在不一致的，就添加一个值，这里主要用于包装数量的计算，主要用于 大中小
                if (!StringUtils.equals(children.getBarCode(), parentEipModel.getBarCode())) {
                    integerCalculationEnumMap.put(CalculationEnum.UP_IS_INCONSISTENT.value(), CalculationEnum.UP_IS_INCONSISTENT);
                }
                //  大、中类型不一致
                if (sonCodeType.equals(CodeTypeEnum.MID) && parenCodeType.equals(CodeTypeEnum.BIG)) {
                    if (!StringUtils.equals(children.getBarCode(), parentEipModel.getBarCode())) {
                        integerCalculationEnumMap.put(CalculationEnum.IS_ERROR.value(), CalculationEnum.IS_ERROR);
                    }
                }
                //  大、小类型不一致
                if ((parenCodeType.equals(CodeTypeEnum.BIG) && sonCodeType.equals(CodeTypeEnum.ROD)) ||
                        parenCodeType.equals(CodeTypeEnum.BIG) && sonCodeType.equals(CodeTypeEnum.SMALL)) {
                    if (!StringUtils.equals(children.getBarCode(), parentEipModel.getBarCode())) {
                        integerCalculationEnumMap.put(CalculationEnum.IS_ERROR.value(), CalculationEnum.IS_ERROR);
                    }
                }
                packageData(children, integerCalculationEnumMap);
            }
        }
    }

    /**
     * <br/> 1. 校验数据
     * <br/> 2. 获取码产品信息
     * <br/> 3. 删除解绑数据
     *
     * @param chainTreeEipModels
     * @return
     */
    private Map<String, QtsCodeProductInfo> checkData(List<QtsCodeChainTreeEipModel> chainTreeEipModels) {
        // 直接给这么多，后续根据数据的大小来
        List<String> idLsts = new ArrayList<>(500);
        // 在校验数据的时候，将所有的数据补齐产品信息
        for (QtsCodeChainTreeEipModel chainTreeEipModel : chainTreeEipModels) {
            QtsCodeChainEipModel relationTree = chainTreeEipModel.getRelationTree();
            idLsts.add(relationTree.getCurrentId().toString());
            if (relationTree != null) {
                // 递归获取所有的数据ID，放入打集合中
                recursion(relationTree, idLsts);
            }
        }
        // 然后将所有的数据查询出来，进行封装
        List<QtsCodeProductInfo> qtsCodeProductInfo = getQtsCodeProductInfo(idLsts);
        // 如果没有查到，或者 码链路数据和 码产品数据对不上
        if (CollectionUtils.isEmpty(qtsCodeProductInfo)) {
            throw PamirsException.construct(QtsEipExpEnumerate.CODE_CHAIN_TREE_ERRR).errThrow();
        }
        Map<String, QtsCodeProductInfo> collect = qtsCodeProductInfo.stream()
                .collect(Collectors.toMap(QtsCodeProductInfo::getSerialNo, Function.identity()));
        for (String idLst : idLsts) {
            if (collect.get(idLst) == null) {
                throw PamirsException.construct(QtsEipExpEnumerate.CODE_CHAIN_TREE_ERRR).errThrow();
            }
        }
        return collect;
    }


    /**
     * 这里有一个问题，比如如果中盒解绑了，那下游还需要处理嘛？
     *
     * @param qtsCodeChainEipModel
     * @param idLsts
     */
    private static void recursion(QtsCodeChainEipModel qtsCodeChainEipModel, List<String> idLsts) {
        List<QtsCodeChainEipModel> childrens = qtsCodeChainEipModel.getChildrens();
        if (!CollectionUtils.isEmpty(childrens)) {
            for (int i = childrens.size() - 1; i >= 0; i--) {
                QtsCodeChainEipModel children = childrens.get(i);
                // 如果是解绑的就删除..
                if (children.getStatus() == 1) {
                    childrens.remove(i);
                }
                idLsts.add(children.getCurrentId().toString());
                recursion(children, idLsts);
            }
        }
    }

    /**
     * 定义一个入口，方便后续修改..
     *
     * @param ids
     */
    private List<QtsCodeProductInfo> getQtsCodeProductInfo(List<String> ids) {
        // 通过JSON 解析
        return JSONUtisl.getProduct();
//        return qtsCodeProductInfoQueryService.queryListBySerialNos(ids);
    }

}