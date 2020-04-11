package cn.lwb.dao;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.lwb.dao.dao.UserRepository;
import cn.lwb.dao.pojo.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        User user = new User("aa111", "aa@126.com", "aa11", "aa12345611", formattedDate);
        System.out.println(user.toString());
        userRepository.save(user);
        userRepository
                .save(new User("bb211", "bb@126.com", "bb11", "bb12345611", formattedDate));
        userRepository
                .save(new User("cc311", "cc@126.com", "cc11", "cc12345611", formattedDate));
        List<User> findAll = userRepository.findAll();
        System.out.println(findAll.toString());
        User userBy = userRepository.findByUserNameOrEmail("bb", "cc@126.com");
        System.out.println(userBy.toString());
        userRepository.delete(userRepository.findByUserName("aa1"));
    }
}