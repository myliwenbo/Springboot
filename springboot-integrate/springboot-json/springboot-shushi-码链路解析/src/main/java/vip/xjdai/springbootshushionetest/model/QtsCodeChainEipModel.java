package vip.xjdai.springbootshushionetest.model;

import lombok.Data;
import vip.xjdai.springbootshushionetest.enums.CodeTypeEnum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class QtsCodeChainEipModel implements Serializable {

    /**
     * parentId	父节点ID
     **/
    private Long parentId;

    /**
     * currentId	当前节点ID
     **/
    private Long currentId;

    /**
     * 顶部节点ID
     **/
    private Long topId;

    /**
     * 当前节点状态,0-绑定,1-解绑
     **/
    private Long status;

    /**
     * 69码
     */
    private String barCode;

    /**
     * 包装数量
     */
    private BigDecimal quantity;

    /**
     * 异常状态：{@link pro.shushi.mizar.qts.tracecode.api.enumeration.CodeAnalysisStatusEnum}
     */
    private Integer analysisStatus;

    /**
     * 码类型 {@link pro.shushi.mizar.qts.tracecode.api.enumeration.CodeTypeEnum }
     */
    private Integer codeTypeEnum;
    /**
     * <br/> true  ： 正常数据，用于判断大中小是否一致
     * <br/> false ： 异常数据，不一致的话按照中盒计算
     * 判断下层是否有一致的，这里是用于 计算包装数量<br/>
     * {@link pro.shushi.mizar.qts.eip.core.third.codecenter.service.pull.QtsCodeChainTreePullOperate#bigMidSmall(pro.shushi.mizar.qts.eip.api.third.codecenter.tmodel.QtsCodeChainEipModel, java.math.BigDecimal, java.lang.Boolean, java.lang.Boolean)}
     */
    private Boolean upIsInconsistent;
    /**
     * <br/> true  ： 补码数据
     * <br/> false ： 未补码数据
     * 是否为补码
     */
    private Boolean isComplement;
    /**
     * <br/> true  ： 是特殊产品，按照小盒计算
     * <br/> false ： 不是特殊产品，按照中盒计算
     * 是否为补码，这里单独罗列出来是因为要计算 大中小的..
     */
    private Boolean calculationMode;

    /**
     * 是否存在规格表中
     */
    private Integer existInSpec;

    /**
     * 标记深度
     * 参考枚举：{@link pro.shushi.mizar.qts.tracecode.api.enumeration.CodeMarkTypeEnum}.
     */
    private Integer packageType;

    /**
     * 错误信息，当发生错误的时候才会有..
     */
    private String analysisErrReason;

    /**
     * 产品编码
     */
    private String bindSkuCode;

    /**
     * 产品名称
     */
    private String bindSkuName;

    /**
     * childrens	子节点集合
     */
    private List<QtsCodeChainEipModel> childrens;
}
