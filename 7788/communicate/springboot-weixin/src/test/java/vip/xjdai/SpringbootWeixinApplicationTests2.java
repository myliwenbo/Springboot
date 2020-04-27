package vip.xjdai;

import java.lang.reflect.Field;

import org.junit.Test;

import vip.xjdai.bean.ReceiveXmlEntity;

public class SpringbootWeixinApplicationTests2 {

    @Test
    public void contextLoads() {
        try {
            ReceiveXmlEntity rx = new ReceiveXmlEntity();
            Class<? extends ReceiveXmlEntity> clazz = rx.getClass();
            Field field = clazz.getDeclaredField("ToUserName");
            field.setAccessible(true);
            field.set(rx, "123");
            System.out.println(rx.getToUserName());

        } catch (Exception e) {
        }

    }

}
