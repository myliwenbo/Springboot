package cn.lwb.annotation.dynamic.service.impl;

import org.springframework.stereotype.Service;

import cn.lwb.annotation.dynamic.service.TestService;

@Service
public class TestServiceImpl2 implements TestService {

    @Override
    public String whoAmI() {

        return "我是原配2";

    }

}
