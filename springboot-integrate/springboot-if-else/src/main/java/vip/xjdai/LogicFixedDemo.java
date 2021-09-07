package vip.xjdai;


import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * 逻辑固定的if..else处理
 */
public class LogicFixedDemo {
    //前台传递的参数
    Integer s = 1;
    @Test
    public void LogicFixed1() throws Exception {

        if (Objects.equals(s, ReqeustSelestEumu.SELECT_ORDER.getCode())) {
            System.out.println("处理：" + s);
        } else if (Objects.equals(s, ReqeustSelestEumu.SELECT_ORDER_ALL.getCode())) {
            System.out.println("处理：" + s);
        } else if (Objects.equals(s, ReqeustSelestEumu.SELECT_ORDER_BY_ID.getCode())) {
            System.out.println("处理：" + s);
        }

    }

    @Test
    public void LogicFixed2() throws Exception {
        //
        Map<String, ReqeustSelestEumu> actionMappings = Maps.newHashMap(); // 这里泛型 ? 是为方便演示，实际可替换为你需要的类型
        actionMappings.put("1", ReqeustSelestEumu.SELECT_ORDER);
        actionMappings.put("2", ReqeustSelestEumu.SELECT_ORDER_ALL);
        actionMappings.put("3", ReqeustSelestEumu.SELECT_ORDER_BY_ID);
        ReqeustSelestEumu reqeustSelestEumu = actionMappings.get(s);
    }

}

enum ReqeustSelestEumu {

    SELECT_ORDER(1, "查询订单"),
    SELECT_ORDER_ALL(2, "查询所有订单"),
    SELECT_ORDER_BY_ID(3, "根据ID查询"),
    ;
    private Integer code;
    private String depict;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict;
    }

    ReqeustSelestEumu(Integer code, String depict) {
        this.code = code;
        this.depict = depict;
    }
}
