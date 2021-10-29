package vip.xjdai.controller;

import lombok.Data;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.FactoryBean.FactoryBeanTest;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

@Data
@RestController
@RequestMapping("TestControllere")
public class TestControllere extends Object {
    @Autowired
    private FactoryBeanTest factoryBeanTest;

    @RequestMapping("test")
    public void test(String myNames) throws IOException {

    }
}
