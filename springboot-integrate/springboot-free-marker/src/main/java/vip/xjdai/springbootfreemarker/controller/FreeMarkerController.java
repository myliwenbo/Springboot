package vip.xjdai.springbootfreemarker.controller;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.springbootfreemarker.model.User;
import vip.xjdai.springbootfreemarker.utils.FreeMarkerUtils;

import java.util.HashMap;

@Controller
@RequestMapping("test")
public class FreeMarkerController {

    @RequestMapping(value = "index")
    public String index(ModelMap map) {
        User value = new User();
        value.setName("张三");
        value.setPassword("1234");
        value.setAddress("杭州市");
        value.setPhone("110");
        value.setAge(100);
        map.addAttribute("user", value);
        return "freemarker/index";
    }
}
