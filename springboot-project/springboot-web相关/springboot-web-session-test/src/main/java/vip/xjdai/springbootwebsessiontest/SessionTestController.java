package vip.xjdai.springbootwebsessiontest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("SessionTestController")
public class SessionTestController {

    @RequestMapping("test")
    public void test(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        HttpSession session = httpServletRequest.getSession();
        System.out.println(session.getId());
        Cookie cookie = new Cookie("username", "zhangsan");
        cookie.setPath("/"); //设置路径
        httpServletResponse.addCookie(cookie); //添加到缓存到浏览器
    }
}
