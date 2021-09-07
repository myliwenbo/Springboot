package vip.xjdai.avlidationtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import vip.xjdai.avlidationtest.model.pojo.UserPOJO;

import javax.validation.ConstraintViolation;
import java.util.Set;

@SpringBootTest
class AvlidationTestApplicationTests {

    @Autowired
    private LocalValidatorFactoryBean localValidatorFactoryBean;

    @Test
    void contextLoads() {
        UserPOJO value = new UserPOJO();
        Set<ConstraintViolation<UserPOJO>> validate = localValidatorFactoryBean.getValidator().validate(value);
        // 输出错误消息
        validate.stream().map(v -> v.getPropertyPath() + " " + v.getMessage() + ": " + v.getInvalidValue())
                .forEach(System.out::println);    }

}
