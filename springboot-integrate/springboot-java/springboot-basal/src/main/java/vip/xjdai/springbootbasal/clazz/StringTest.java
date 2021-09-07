package vip.xjdai.springbootbasal.clazz;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

public class StringTest {

    public static void main(String[] args) {
        String s = "hello";
        String s1 = s + "word";
        String s2 = "hello";
        System.out.println(s.equals(s2));
        String intern = s2.intern();
        System.out.println(intern);
        System.out.println("a".compareTo("b"));
        System.out.println("b".compareTo("a"));

    }
    @Test
    public void test2() throws Exception {
        Erasure<String> erasure = new Erasure<String>("hello");
        Class eclz = erasure.getClass();
        System.out.println("erasure class is:" + eclz.getName());
        Field[] fs = eclz.getDeclaredFields();
        for (Field f : fs) {
            System.out.println("Field name " + f.getName() + " type:" + f.getType().getName());
        }
    }
}
