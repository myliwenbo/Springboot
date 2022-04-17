package vip.xjdai.springbootdbug.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("testController")
public class Test {

    @RequestMapping("test")
    public void test(Integer integer) {
        for (int i = 0; i < integer; i++) {
            System.out.println(i);
        }
    }
}
