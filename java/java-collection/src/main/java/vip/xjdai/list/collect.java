package vip.xjdai.list;

import org.junit.Before;
import org.junit.Test;
import vip.xjdai.list.pojo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class collect {
    List<User> list = new ArrayList<>();

    @Before
    public void addList() {
        for (int i = 0; i < 100; i++) {
            list.add(new User("小明" + i, 18 + i));
        }
    }


    @Test
    public void toMap() throws Exception {
        Map<Integer, User> collect = list.stream().collect(Collectors.toMap(User::getAge, Function.identity()));
        System.out.println(collect);
    }


}
