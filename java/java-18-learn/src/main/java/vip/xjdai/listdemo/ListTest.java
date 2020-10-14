package vip.xjdai.listdemo;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 参考  https://blog.csdn.net/chenhao_c_h/article/details/80691284
 */
public class ListTest {
    List<User> list = Lists.newArrayList();

    @Before
    public void beforeTest() throws Exception {
        for (int i = 0; i < 100; i++) {
            list.add(new User("小明" + i, 18 + i));
        }
    }

    @Test
    public void forEach() throws Exception {
        //打印数据库数据
        list.forEach(System.out::println);
        // 循环属性
        list.forEach(u -> {
            System.out.println(u.getAge());
        });
    }


    @Test
    public void filter() throws Exception {
        //将年龄大于19的添加到新的集合中去
        List<User> collect = list.stream()
                .filter(u -> u.getAge() > 19)
                .collect(Collectors.toList());
        //将年龄大于19的添加到新的集合中去
        collect = list.stream()
                .filter(new Predicate<User>() {
                    @Override
                    public boolean test(User user) {
                        return user.getAge() > 18;
                    }
                })
                .collect(Collectors.toList());
        collect.forEach(e -> System.out.println(e.getName()));

    }

    @Test
    public void map() throws Exception {
        //获取年龄然后插入到新的集合中去
        List<Integer> collect = list.stream().map(User::getAge).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    @Test
    public void anyMatch() throws Exception {
        List<User> list = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(new User("小明" + i, 18 + i));
        }
        //判断数据集合的数据是否有小于19的
        boolean b = list.stream().anyMatch(u -> u.getAge() < 19);
        System.out.println(b);

    }
}

@Data
@AllArgsConstructor
class User {
    private String name;
    private Integer age;

}
