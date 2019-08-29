/**
 * 
 */
package vip.xjdai.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("test")
    public void test()
    {

        Set<String> keys = stringRedisTemplate.keys("*");
        for (String string : keys) {
            System.out.println(string);
        }

    }
}
