package vip.xjdai.secunitylogout.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SuccessController {

    @RequestMapping("defaultSuccessUrl")
    public String defaultSuccessUrl() {
        return "defaultSuccessUrl登陆成功";
    }

    @RequestMapping("successForwardUrl")
    public String test() {
        return "successForwardUrl登陆成功";
    }
}
