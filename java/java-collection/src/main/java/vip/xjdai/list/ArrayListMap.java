package vip.xjdai.list;

import org.junit.Before;
import org.junit.Test;
import vip.xjdai.list.pojo.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayListMap {
    List<User> list = new ArrayList<>();

    @Before
    public void addList() {
        for (int i = 0; i < 100; i++) {
            list.add(new User("小明" + i, 18 + i));
        }
        list.forEach(System.out::println);
    }

    /**
     * 将某个人的年龄插入到新的集合中去
     *
     * @throws Exception
     */
    @Test
    public void map() throws Exception {
        //获取年龄然后插入到新的集合中去
        Stream<Integer> integerStream = list.stream().map(User::getAge);
        List<Integer> collect = list.stream().map(User::getAge).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    /**
     * 将
     *
     * @throws Exception
     */
    @Test
    public void mapFilter() throws Exception {
        //获取年龄然后插入到新的集合中去
        List<Integer> collect = list.stream()
                .map(item -> item.getAge() != null && item.getAge() > 20 ? item.getAge() : null)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    @Test
    public void mapNewList() throws Exception {
        //获取年龄然后插入到新的集合中去
        List<User> collect = list.stream().map(item -> new User(item.getName(), null)).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

}
