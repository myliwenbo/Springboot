package vip.xjdai.ForDependence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class A {
    @Autowired
    private  B b;

    public static void main(String[] args) {
    }
}
