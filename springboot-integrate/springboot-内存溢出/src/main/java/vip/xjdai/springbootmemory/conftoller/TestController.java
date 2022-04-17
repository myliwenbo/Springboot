package vip.xjdai.springbootmemory.conftoller;

import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("TestController")
public class TestController {

    @RequestMapping("test")
    public void test() {
        ArrayList<Object> objects = Lists.newArrayList();
        while (true) {
            objects.add(UUID.randomUUID().toString());
        }
    }
}
