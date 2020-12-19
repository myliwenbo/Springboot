package vip.xjdai.javabase.Clazz;

import java.util.Date;

public class ClassDEMO extends Date {

    public static void main(String[] args) {
        new ClassDEMO().test();
    }

    public void test() {
        //返回的是Test类名
        System.out.println(super.getClass().getName());
        // 为什么？因为 getClass 这个方法定义成了 final 子类是不能覆盖的
    }

}
