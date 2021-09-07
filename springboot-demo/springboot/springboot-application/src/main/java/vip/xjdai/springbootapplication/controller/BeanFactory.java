package vip.xjdai.springbootapplication.controller;

public class BeanFactory {

    public void getBean(String claszz) throws Exception {
        Class<?> aClass = Class.forName(claszz);
        Object o = aClass.newInstance();
    }
}
