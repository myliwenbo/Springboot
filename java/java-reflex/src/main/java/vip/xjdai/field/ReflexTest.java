package vip.xjdai.field;

import org.junit.Test;

import java.lang.reflect.Field;

public class ReflexTest {


    @Test
    public void fieldTest() throws Exception {

        Class<?> clazz = ReflexDemo.class;
        //通过反射获取该类的所有属性包括private
        Field[] declaredFields = clazz.getDeclaredFields();
    }
}
