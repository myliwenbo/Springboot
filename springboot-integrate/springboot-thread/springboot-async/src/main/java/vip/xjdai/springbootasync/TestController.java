package vip.xjdai.springbootasync;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("TestController")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("test")
    public void test() throws Exception {
        this.testService.test();

    }
}
