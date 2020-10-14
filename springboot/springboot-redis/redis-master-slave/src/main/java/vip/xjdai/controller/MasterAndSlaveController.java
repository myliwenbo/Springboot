package vip.xjdai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("masterSlave")
public class MasterAndSlaveController {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("add")
    public ResponseEntity<String> add() {
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set("book", "武侠");
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
}
