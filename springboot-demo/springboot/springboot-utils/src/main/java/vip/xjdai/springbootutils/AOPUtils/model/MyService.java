package vip.xjdai.springbootutils.AOPUtils.model;

import org.springframework.stereotype.Component;

@Component
public class MyService {

    public void someLogic() {
        System.out.println("component");
    }

}