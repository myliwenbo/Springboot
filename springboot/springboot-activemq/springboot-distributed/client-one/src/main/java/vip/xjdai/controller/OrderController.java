package vip.xjdai.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("order")
public class OrderController {

    /**
     * @Description TODO
     * @param @return 参数
     * @return String 返回类型
     * @throws userID：转账的用户ID
     * amount：转多少钱
     */

    @Autowired
    @Qualifier("activemq")
    OrderServiceActivemqImpl orderService;

    @RequestMapping("/transfer")
    public @ResponseBody
    String transferAmount(String userId, String messageId, int amount) {
        try {
            orderService.updateAmount(amount, messageId, userId);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "sessiom";
    }

    @RequestMapping("/callback")
    public String callback(String param) {

        JSONObject parse = JSONObject.parseObject(param);
        String respCode = parse.getString("respCode");
        if (!"OK".equalsIgnoreCase(respCode)) {
            return null;
        }
        try {
            orderService.updateMessage(param);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "ok";
    }
}