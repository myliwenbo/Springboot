package cn.lwb.aop.dynamic.service;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl2 implements TestService {

    @Override
    public String whoAmI() {

        return "我是原配2";

    }

}
