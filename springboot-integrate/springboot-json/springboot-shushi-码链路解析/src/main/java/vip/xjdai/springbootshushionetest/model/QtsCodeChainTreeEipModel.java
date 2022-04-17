
package vip.xjdai.springbootshushionetest.model;

import lombok.Data;
import vip.xjdai.springbootshushionetest.enums.CodeMarkTypeEnum;

import java.io.Serializable;

/**
 * 大箱 or 小箱
 */
@Data
public class QtsCodeChainTreeEipModel implements Serializable {

    /**
     * 标记深度
     * 参考枚举：{@link CodeMarkTypeEnum}<br/>
     * 参考使用：CodeMarkTypeEnum.getEnumByValue(CodeMarkTypeEnum.class, integer);
     */
    private Integer mark;

    /**
     * 标记最底层的数据类型
     * 参考枚举：CodeTypeEnum
     */
    private Integer markType;

    /**
     * 序列号，相当于是大箱的序列号，这里有一个奇怪的点是，这里的ID是和码链路的ID是一致的
     **/
    private Long id;

    /**
     * 是否为异常数据
     * <br/> true  ： 异常数据
     * <br/> false ： 正常数据
     * <br/>  {@link pro.shushi.mizar.qts.eip.core.third.codecenter.service.pull.QtsCodeChainTreePullOperate#filterErrorData(java.util.List)}
     */
    private Boolean isError;

    /**
     * 码链路
     */
    private QtsCodeChainEipModel relationTree;

}
