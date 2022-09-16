package vip.xjdai.viewcontrollerregistry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping
public class AbsentController {

    @RequestMapping("absent")
    public String test() {
        return "index";
    }
}
