package vip.xjdai.springbootredirect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("TestController")
public class TestController {

    @RequestMapping(value = "test")
    public String test(HttpServletResponse httpServletResponse) throws IOException {
        return "redirect:http://www.bilibili.com/";

    }

    @RequestMapping(value = "httpRedirect")
    public void httpRedirect(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendRedirect("http://www.bilibili.com/");
    }
}