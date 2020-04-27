package vip.xjdai.ioc.service;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public String whoAmI() {
        return "我是原配";

    }

}
