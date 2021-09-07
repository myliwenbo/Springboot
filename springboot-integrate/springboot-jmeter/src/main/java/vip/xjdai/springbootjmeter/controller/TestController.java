package vip.xjdai.springbootjmeter.controller;

import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {
    private List<Integer> list = Lists.newArrayListWithCapacity(10000);
    private int i = 0;

    @RequestMapping("test")
    public int test() {
        list.add(i++);
        return i;
    }

    @RequestMapping("synchronized/test")
    public synchronized int synchronizedTest() {
        list.add(i++);
        return i;
    }
}
