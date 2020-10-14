package vip.xjdai.validation.difference.controller;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.validation.difference.pojo.ValidPOJO;

import javax.validation.Valid;

@RestController
@RequestMapping("validController")
public class ValidController {

    @RequestMapping("add")
    public ValidPOJO add(@RequestBody @Valid ValidPOJO validPOJO) {
        return validPOJO;

    }
}
