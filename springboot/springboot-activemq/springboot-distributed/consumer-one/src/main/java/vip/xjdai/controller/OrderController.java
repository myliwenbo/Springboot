package vip.xjdai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;
    @RequestMapping("/transfer")
    public @ResponseBody
    String transferAmount(String userId, String amount) {
        try {
            orderService.updateAmount(Integer.valueOf(amount), userId);
        } catch (Exception e) {
            e.printStackTrace();
            return "===============================transferAmount failed===================";
        }

        return "===============================transferAmount successfull===================";
    }
}