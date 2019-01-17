package cn.lwb.spirng.bean;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

/**
 * 父类转换子类利用SpringBean
 * @author lwb
 *
 */
public class SuperThrnSub {

    @Test
    public void testname() throws Exception {
        User user = new User();
        user.setAge("18");
        user.setName("小明");
        UserSuper userSuper = (UserSuper) user;
        System.out.println(userSuper.getName());

    }

    @Test
    public void superThrnSub() throws Exception {
        UserSuper userSuper = new UserSuper();
        userSuper.setAge("18");
        userSuper.setName("小明");
        User user = new User();
        user.setSex("name");
        BeanUtils.copyProperties(userSuper, user);
        System.out.println(user.getAge());
    }
}
