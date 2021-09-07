package vip.xjdai.springbootclass;

import com.google.common.collect.Maps;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.security.Key;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@MyTest(memberValues = "嘻嘻")
public class TestClass {

    @Test
    public void beanToXml() throws Exception {
        TestClass testClass = new TestClass();
        //获取到类上的注解
        MyTest annotation = testClass.getClass().getAnnotation(MyTest.class);
        //获取这个代理实例所持有的 InvocationHandler
        InvocationHandler ih = Proxy.getInvocationHandler(annotation);
        // 获取 AnnotationInvocationHandler 的 memberValues 字段
        Field memberValuesField = ih.getClass().getDeclaredField("memberValues");
        memberValuesField.setAccessible(true);
        Map memberValues = (Map) memberValuesField.get(ih);
        //修改注解的name属性的值设置为value
        memberValues.put("memberValues", "value");
        System.out.println(testClass.getClass().getAnnotation(MyTest.class).memberValues());
    }

    @Test
    public void test2() throws Exception {


    }
}

