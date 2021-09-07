package vip.xjdai.springbootjava.Cloneable.list.api;



import org.junit.jupiter.api.Test;
import vip.xjdai.springbootjava.Cloneable.list.pojo.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 排序
 */
public class ArrauListSorted {


    @Test
    public void sorted() throws Exception {
        User u1 = new User("陈一", 32);
        User u2 = new User("陈二", 23);
        User u3 = new User("陈三", 33);
        List<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u2);
        users.add(u3);
        //按User的年龄正序排序（默认ASC排序）
        List<User> collect = users.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
        System.out.println(collect); //[{name = '陈二',age =23},{name = '陈一',age =32},{name = '陈三',age =33}]
        //按User的年龄倒序排序（DESC排序）
        collect = users.stream().sorted(Comparator.comparing(User::getAge).reversed()).collect(Collectors.toList());
        System.out.println(collect); //[{name = '陈三',age =33},{name = '陈一',age =32},{name = '陈二',age =23}]
    }

    @Test
    public void sortedIsNull() throws Exception {
        User u1 = new User("陈一", 32);
        User u2 = new User("陈二", null);
        User u3 = new User("陈三", 33);
        List<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u2);
        users.add(u3);
        //按User的年龄正序排序（默认ASC排序）
        List<User> collect = users.stream().sorted(Comparator.comparing(User::getAge,Comparator.nullsFirst(Integer::compareTo))).collect(Collectors.toList());
        System.out.println(collect); //[{name = '陈二',age =23},{name = '陈一',age =32},{name = '陈三',age =33}]
        //按User的年龄倒序排序（DESC排序）
//        collect = users.stream().sorted(Comparator.comparing(User::getAge).reversed()).collect(Collectors.toList());
        System.out.println(collect); //[{name = '陈三',age =33},{name = '陈一',age =32},{name = '陈二',age =23}]
        ;
    }
}
