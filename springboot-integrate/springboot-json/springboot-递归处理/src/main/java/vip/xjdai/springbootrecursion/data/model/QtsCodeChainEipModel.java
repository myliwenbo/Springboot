package vip.xjdai.springbootrecursion.data.model;

import lombok.Data;

import java.io.Serializable;
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
     * childrens	子节点集合
     */
    private List<QtsCodeChainEipModel> childrens;
}
