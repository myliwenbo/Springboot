package vip.xjdai.viewresolverjsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import vip.xjdai.viewresolverjsp.model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    /**
     * 获取用户信息，到jsp页面进行展示
     */
    @RequestMapping("/userList")
    public String getUsersAll(Model model) {
        //访问业务层-->数据访问层mapper-->mybatis数据库获取所有用户信息
        //模拟，定义固定的用户信息
        List<User> list = new ArrayList<User>();
        list.add(new User("007", "小张", 22));
        list.add(new User("009", "小康", 32));
        list.add(new User("012", "小健", 18));
        model.addAttribute("list", list);
        //配置springmvc的视图解析器，前缀：/WEB-INF/   后缀: .jsp
        return "index";
    }
}

