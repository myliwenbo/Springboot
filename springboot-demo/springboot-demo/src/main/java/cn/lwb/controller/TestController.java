
package cn.lwb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lwb
 */
@RestController
@RequestMapping("test")
public class TestController {
    int i = 0;

    @RequestMapping("test")
    public String test() {
        i += 1;
        System.out.println(i);
        return "OK";
    }
}
