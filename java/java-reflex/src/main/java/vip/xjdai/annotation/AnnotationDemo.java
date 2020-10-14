package vip.xjdai.annotation;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

@ApiField
public class AnnotationDemo {


    @Test
    public void dmeo1() throws Exception {
        ApiField annotation = AnnotationDemo.class.getAnnotation(ApiField.class);
        System.out.println(annotation.paramValue());
        Class<? extends ApiField> aClass = annotation.getClass();
        Field paramValue = aClass.getDeclaredField("paramValue");
        paramValue.setAccessible(true);
        paramValue.set(annotation, "张三");


//        InvocationHandler ih = Proxy.getInvocationHandler(annotation);
//        Field memberValuesField = ih.getClass().getDeclaredField("memberValues");
//        memberValuesField.setAccessible(true);
//        Map memberValues = (Map) memberValuesField.get(ih);
//        //修改注解的name属性的值设置为value
//        memberValues.put("name", "value");
    }
}
