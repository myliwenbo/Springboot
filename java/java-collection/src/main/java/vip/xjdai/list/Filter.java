package vip.xjdai.list;

import org.junit.Before;
import org.junit.Test;
import vip.xjdai.list.pojo.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filter {
    List<User> list = new ArrayList<>();

    @Before
    public void addList() {
        for (int i = 0; i < 100; i++) {
            list.add(new User("小明" + i, 18 + i));
        }
    }


    @Test
    public void filter() throws Exception {
        //将年龄大于19的添加到新的集合中去
        List<User> collect = list.stream().filter(u -> u.getAge() > 19).collect(Collectors.toList());
    }


    @Test
    public void anyMatch() throws Exception {
        //判断数据集合的数据是否有小于19的
        boolean b = list.stream().anyMatch(u -> u.getAge() < 19);
        System.out.println(b);
    }

    @Test
    public void anyMatch1() throws Exception {
        Stream<String> stream = Stream.of("hello", "world");
        Optional<String> optional = stream.findFirst();
        String name = optional.map(String::toLowerCase).orElse("");
        System.out.println(name);
        String s = Stream.of("hello", "world").findFirst().map(String::toLowerCase).orElse("");
        list.sort(Comparator.comparing(User::getAge));
        User user = list.stream().findFirst().get();
        System.out.println(user);
    }
}
