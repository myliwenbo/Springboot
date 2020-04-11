package vip.xjdai.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.junit.Test;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

import static junit.framework.TestCase.assertEquals;

/**
 * 参考：https://www.cnblogs.com/zhangboyu/p/7580262.html
 */
public class OptionalTest {

    @Test
    public void OptionalApi1() throws Exception {
        User user = new User();
        if (user != null) {
            User.Address address = user.getAddress();
            if (address != null) {
                User.Address.Country country = address.getCountry();
                if (country != null) {
                    String isocode = country.getIsocode();
                    if (isocode != null) {
                        isocode = isocode.toUpperCase();
                    }
                }
            }
        }

    }

    @Test
    public void empty() throws Exception {
        Optional<User> emptyOpt = Optional.empty();
        User user1 = emptyOpt.get();
    }

    @Test
    public void of() throws Exception {
        User user = new User();
        //明确 对象不是null的时候使用of
        Optional<User> opt = Optional.of(user);
    }

    @Test
    public void ofNullable() throws Exception {
        //如果对象即可能是 null 也可能是非 null，你就应该使用 ofNullable() 方法：
        Optional<User> emptyOpt = Optional.ofNullable(new User());
        User user1 = emptyOpt.get();
    }

    @Test
    public void get() throws Exception {
        //如果对象即可能是 null 也可能是非 null，你就应该使用 ofNullable() 方法：
        Optional<User> emptyOpt = Optional.ofNullable(new User());
        //获取实际值
        User user1 = emptyOpt.get();
    }

    @Test
    public void isPresent() throws Exception {
        User user = new User(null, "john@gmail.com", "1234");
        Optional<User> opt = Optional.ofNullable(user);
        opt.ifPresent(new Consumer<User>() {
            @Override
            public void accept(User u) {
                assertEquals(user.getEmail(), u.getEmail());
            }
        });
        //当User 不为空的时候才去执行，当一个对象的值去Set到另外一个对象时候使用
        opt.ifPresent((u) -> System.out.println(opt.get().getEmail()));
    }

    /**
     * 返回默认值
     *
     * @throws Exception
     */
    @Test
    public void orElse() throws Exception {
        String s = null;
        String ss = "我爱你啊";
        //如果s是空的则返回SS，如果s有值则返回s忽略SS
        String s1 = Optional.ofNullable(s).orElse(ss);
        System.out.println(s1);
    }

    /**
     * 返回默认值
     *
     * @throws Exception
     */
    @Test
    public void orElseGet() throws Exception {
        String s = null;
        String ss = "我爱你啊";
        //如果s是空的则返回SS，如果s有值则返回s忽略SS
        String s1 = Optional.ofNullable(s).orElseGet(() -> ss);
        System.out.println(s1);
    }

    /**
     * 转换值
     *
     * @throws Exception
     */
    @Test
    public void map() throws Exception {
        User user = new User(null, "john@gmail.com", "1234");
        //如果s是空的则返回SS，如果s有值则返回s忽略SS
        Optional<User> optionalUser = Optional.ofNullable(user);
        Optional<String> optionalString = optionalUser.map(User::getEmail);
        System.out.println(optionalString.get());
    }

    /**
     * 转换值
     *
     * @throws Exception
     */
    @Test
    public void map2() throws Exception {
        User user = new User(null, "john@gmail.com", "1234");
        //如果s是空的则返回SS，如果s有值则返回s忽略SS
        Optional<String> s = Optional.ofNullable(user)
                .map(User::getAddress)
                .map(User.Address::getCountry)
                .map(User.Address.Country::getIsocode);
        System.out.println(s);
    }

    @Data
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class User {

        private Address address;

        private String email;
        private String paswword;


        @Data
        public static class Address {
            private Country country;

            @Data
            public static class Country {
                private String isocode;
            }
        }
    }
}
