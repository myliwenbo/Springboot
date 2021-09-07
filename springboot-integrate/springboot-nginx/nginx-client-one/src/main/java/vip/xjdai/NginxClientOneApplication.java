package vip.xjdai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RequestMapping("nginx")
@RestController
@SpringBootApplication
public class NginxClientOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(NginxClientOneApplication.class, args);
    }

    @RequestMapping("test")
    public String test1(HttpServletRequest httpServletRequest) {
        System.out.println("one");
        System.out.println("请求的服务端名称或者IP：" + httpServletRequest.getServerName());
        System.out.println("请求的URL：" + httpServletRequest.getRequestURL());
        return "ONE";
    }
}
