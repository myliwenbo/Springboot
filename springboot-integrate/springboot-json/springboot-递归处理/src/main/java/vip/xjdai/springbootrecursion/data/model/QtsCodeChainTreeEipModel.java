package vip.xjdai.springbootrecursion.data.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class QtsCodeChainTreeEipModel implements Serializable {


    /**
     * 序列号
     **/
    private Long id;

    /**
     * 码链路
     */
    private QtsCodeChainEipModel relationTree;

}
