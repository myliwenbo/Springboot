package vip.xjdai.springbootredisconcurrently.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.springbootredisconcurrently.model.UserModel;

@RestController
@RequestMapping("TestController")
public class TestController {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ValueOperations<String, Object> ops;

    @Autowired
    public TestController(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.ops = redisTemplate.opsForValue();
    }

    @RequestMapping("update")
    public void update(String key) {
        //1. 先删除缓存
        redisTemplate.delete(key);
        //2. 更新数据库
        UserModel userModel = updateMysql(key);
        //3. 将新的数据放入到缓存中
        ops.set("zhangsan", userModel);
        // 存在一定的问题，如果 同时并发两个操作 ，一个是 更新 一个是查询，那么就会导致 出现脏读

    }

    /**
     * 更新数据库
     *
     * @param key
     */
    private UserModel updateMysql(String key) {
        if (StringUtils.isNotBlank(key))
            return UserModel.mysqlModelUser(key);
        return UserModel.mysqlModelUser("张三");
    }

    @RequestMapping("query")
    public void query() {
        //1. 查询缓存
        UserModel o = (UserModel) ops.get("key");
        //2. 缓存不存在，查询数据库
        //3. 将新的数据放入到缓存中
    }
}
