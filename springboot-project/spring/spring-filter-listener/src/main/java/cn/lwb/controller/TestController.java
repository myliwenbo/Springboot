package cn.lwb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/index.html")
    public ModelAndView handleRequest() {
        System.out.println("---------TestController executed--------");
        Thread t = new Thread() {
            public void run() {
                try {
                    Thread.sleep(3000L);
                    System.out.println("我第三次执行");
                } catch (InterruptedException e) {
                }
                System.out.println("我应该最后执行");
            }
        }; // 启动线程

        t.start(); // 在sleep()结束前中断它 
        return new ModelAndView("test");
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        System.out.println("---------TestController executed--------");
        Thread t = new Thread() {
            public void run() {
                try {
                    Thread.sleep(3000L);
                    System.out.println("我第三次执行");
                } catch (InterruptedException e) {
                }
                System.out.println("我应该最后执行");
            }
        }; // 启动线程3

        t.start(); // 在sleep()结束前中断它 
        return new ModelAndView("test");
    }

}