package vip.xjdai.jol;

import org.openjdk.jol.info.ClassLayout;

public class JolDemo3 {
    public static void main(String[] args) throws InterruptedException {
        User value = new User();

        System.out.println(ClassLayout.parseInstance(value).toPrintable());
        Integer i= 1;
        System.out.println(ClassLayout.parseInstance(i).toPrintable());
    }
}
