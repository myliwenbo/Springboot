/**
 *
 */
package vip.xjdai.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redis")
public class RestTestController
{

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("listAdd")
    public void listAdd()
    {
        SetOperations< String, String > stringStringSetOperations = stringRedisTemplate.opsForSet();
        String[] s = {};
        for (int i = 0; i < 10000; i++) {
            s[i] = i + "";
        }
        stringStringSetOperations.add("lsit", s);
    }

    @RequestMapping("listBlpop")
    public void listBlpop(){
        SetOperations< String, String > stringStringSetOperations = stringRedisTemplate.opsForSet();
//        stringStringSetOperations.
    }

    @RequestMapping("blAdd")
    public void blAdd(){
        SetOperations< String, String > stringStringSetOperations = stringRedisTemplate.opsForSet();
        stringStringSetOperations.add("asd","ads");
        BoundListOperations< String, String > list = stringRedisTemplate.boundListOps("list");
        //        stringStringSetOperations.
//        stringRedisTemplat
    }


}
