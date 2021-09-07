package vip.xjdai.springbootdesignpattern.strategymode.qikuairongdemo;

import com.google.common.collect.Lists;
import vip.xjdai.springbootdesignpattern.strategymode.qikuairongdemo.itemstrategy.ItemStrategyContext;

import java.util.List;
import java.util.Objects;

/**
 * 原有的代码，Manager有IF语句 和Service有IF语句
 */
public class Manager {


    /**
     * 原有代码，乱糟糟的，大量的if判断....然后到DAO还需要判断
     *
     * @param itemVo
     * @return
     */
    public Object pageList(ItemVo itemVo) {
        if (Objects.equals(ItemSelectTypeEnums.SELECT_ALL_ITEM.getCode(), itemVo.getSelectType())) {
            itemVo.setOrgId(null);
            return pageListAll(itemVo, ItemSelectTypeEnums.SELECT_ALL_ITEM);
        } else if (Objects.equals(ItemSelectTypeEnums.SELECT_PROGRAM_ITEM.getCode(), itemVo.getSelectType())) {
            List<ItemVo> itemVos = pageListAll(itemVo, ItemSelectTypeEnums.SELECT_PROGRAM_ITEM);
            return itemVos.get(0);
        } else if (Objects.equals(ItemSelectTypeEnums.SELECT_ORGANIZATION_ITEM.getCode(), itemVo.getSelectType()) ||
                Objects.equals(ItemSelectTypeEnums.SELECT_CONTACTLESS_ITEM.getCode(), itemVo.getSelectType())) {
            return pageListAll(itemVo, ItemSelectTypeEnums.getItemSelectTypeEnums(itemVo.getSelectType()));
        }
        return pageListAll(itemVo, null);
    }

    private List<ItemVo> pageListAll(ItemVo itemVo, ItemSelectTypeEnums typeEnums) {
        //去数据库查询，以及逻辑的处理
        return Lists.newArrayList();
    }


}

class Service {

    /**
     * 条件查询分页查询
     *
     * @param iditem
     * @param page
     * @return
     */
//    public IPage<Item> pageList(Item iditem, Page<Item> page, ItemSelectTypeEnums typeEnums) {
//        QueryWrapper<Item> itemQueryWrapper = new QueryWrapper<>();
//        if (ItemSelectTypeEnums.SELECT_ALL_ITEM.equals(typeEnums)) {
//            itemQueryWrapper.isNotNull(Item.ORG_ID);
//            itemQueryWrapper.ne(Item.TYPE, ItemTypeEnums.CASE_ITEM.getCode());
//        } else if (ItemSelectTypeEnums.SELECT_PROGRAM_ITEM.equals(typeEnums)) {
//            itemQueryWrapper.eq(Item.TYPE, ItemTypeEnums.CASE_ITEM.getCode()); //查询方案产品
//        } else if (ItemSelectTypeEnums.SELECT_ORGANIZATION_ITEM.equals(typeEnums)) {
//            itemQueryWrapper.eq(ObjectUtils.isNotEmpty(iditem.getOrgId()), Item.ORG_ID, iditem.getOrgId());
//            itemQueryWrapper.eq(Item.TYPE, ItemTypeEnums.NORMAL_ITEM.getCode());
//        } else if (ItemSelectTypeEnums.SELECT_CONTACTLESS_ITEM.equals(typeEnums)) {
//            itemQueryWrapper.eq(Item.TYPE, ItemTypeEnums.EXTERNAL_ITEM.getCode()); //查询外部商品
//        }
//        return itemDao.page(page, itemQueryWrapper);
//    }

    //最后改为
    public Object pageList(Item iditem) {
        QueryWrapper<Item> itemQueryWrapper = new QueryWrapper<>();
        new ItemStrategyContext().contextMethod(itemQueryWrapper, iditem);
        return null;
    }

}

