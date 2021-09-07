package vip.xjdai.springbootgraphqlsimple.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;
import vip.xjdai.springbootgraphqlsimple.model.User;

import java.util.ArrayList;

@Component
public class BookUserResolver implements GraphQLQueryResolver {

    public User getUserById(Integer integer) {
        if (integer.equals(1)) {
            return User.builder()
                    .id(1)
                    .name("Bill Venners")
                    .age(40)
                    .build();
        }
        return null;
    }

    public ArrayList<User> listUser() {
        ArrayList<User> users = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            users.add(User.builder()
                    .id(i)
                    .name("张三：" + i)
                    .age(i)
                    .build());
        }
        return users;
    }
}