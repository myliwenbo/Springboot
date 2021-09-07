package vip.xjdai.springbootvalid.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.springbootvalid.model.User;

import java.util.List;

@RestController
@RequestMapping("TestController")
public class TestController {

    @PostMapping("test")
    public void test(@RequestBody @Validated User user, BindingResult bindingResult) {
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        System.out.println(allErrors);
    }
}
