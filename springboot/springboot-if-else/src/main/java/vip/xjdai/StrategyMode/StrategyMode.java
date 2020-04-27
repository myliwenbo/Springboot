package vip.xjdai.StrategyMode;

import org.junit.Test;
import sun.rmi.runtime.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StrategyMode {

    private static String s = "A";

    //原始代码
    @Test
    public void original() throws Exception {

        if (Objects.equals(s, ReqeustSelestEumu.A.getCode())) {
            //很多行代码
        } else if (Objects.equals(s, ReqeustSelestEumu.B.getCode())) {
            //很多行代码
        } else if (Objects.equals(s, ReqeustSelestEumu.C.getCode())) {
            //很多行代码
        } else if (Objects.equals(s, ReqeustSelestEumu.D.getCode())) {
            //很多行代码
        }


    }


    // 策略模式简化代码
    @Test
    public void original1() {
        Map<String, StrategyModeInterface> handlerMap = new HashMap<>(7);
        handlerMap.put("A", new StrategyModeImplA());
        handlerMap.put("B", new StrategyModeImplB());
        handlerMap.put("C", new StrategyModeImplC());
        handlerMap.put("D", new StrategyModeImplD());
        //根据给定的参数获取, 这样就可以根据指定的类型获取指定的方法执行了
        handlerMap.get(s).loadValue("哈哈哈");
    }

    // 策略模式简化代码
    @Test
    public void original2() {
        Map<String, StrategyModeInterfaceLambda> handlerMap = new HashMap<>(7);
        handlerMap.put("A", value -> {
            //很多代码
            System.out.println("A逻辑");
        });
        handlerMap.put("B", value -> {
            //很多代码
            System.out.println("B逻辑");
        });
        handlerMap.put("C", value -> {
            //很多代码
            System.out.println("C逻辑");
        });
        handlerMap.put("D", value -> {
            //很多代码
            System.out.println("D逻辑");
        });
        handlerMap.get(s).loadValue("哈哈哈");
    }


}

enum ReqeustSelestEumu {

    A("A", "A描述"),
    B("B", "B描述"),
    C("C", "C描述"),
    D("D", "D描述"),
    ;
    private String code;
    private String depict;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict;
    }

    ReqeustSelestEumu(String code, String depict) {
        this.code = code;
        this.depict = depict;
    }
}
