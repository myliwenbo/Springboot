package vip.xjdai.string;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

@RequestMapping("stringTest")
@RestController
public class StrinTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @RequestMapping("getFile")
    public void getFile(String key) throws IOException {
        ValueOperations<String, String> string = stringRedisTemplate.opsForValue();
        String s = string.get(key);
        System.out.println(s.getBytes());
    }

    @RequestMapping("addFile")
    public void addFile(@RequestParam("file") MultipartFile pictureFile) throws IOException {
        byte[] bytes = pictureFile.getBytes();
        addFile(bytes);
    }

    public void addFile(byte[] bytes) {
        ValueOperations<String, String> string = stringRedisTemplate.opsForValue();
        for (int i = 0; i < 5; i++) {
            string.set(UUID.randomUUID().toString(), Arrays.toString(bytes));
        }
    }
}
