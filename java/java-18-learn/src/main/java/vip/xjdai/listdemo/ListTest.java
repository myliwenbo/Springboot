package vip.xjdai.listdemo;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 参考  https://blog.csdn.net/chenhao_c_h/article/details/80691284
 */
public class ListTest {

    @Test
    public void forEach() throws Exception {
        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        list.forEach(System.out::println);
    }

    /**
     * 循环对象
     * @throws Exception
     */
    @Test
    public void forEachBean() throws Exception {
        List<User> list = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(new User("小明" + i, 18 + i));
        }
        list.forEach(u -> {
            System.out.println(u.getAge());
        });
        list.forEach(u -> System.out.println(u.getName()));
    }

    @Test
    public void filter() throws Exception {
        List<User> list = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(new User("小明" + i, 18 + i));
        }
        //将年龄大于19的添加到新的集合中去
        List<User> collect = list.stream()
                .filter(u -> u.getAge() > 19)
                .collect(Collectors.toList());



        List<User> collect1 = list.stream()
                .filter(new Predicate<User>() {
                    @Override
                    public boolean test(User user) {
                        return user.getAge() > 18;
                    }
                })
                .collect(Collectors.toList());



        collect1.forEach(e -> System.out.println(e.getName()));

    }

    @Test
    public void map() throws Exception {
        List<User> list = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(new User("小明" + i, 18 + i));
        }
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
