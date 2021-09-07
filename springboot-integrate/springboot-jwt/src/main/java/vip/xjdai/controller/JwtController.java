/**
 *
 */
package vip.xjdai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vip.xjdai.domain.User;
import vip.xjdai.sign.SignUtil;

/**
 * @author lwb
 *
 */
@RestController
@RequestMapping("test")
public class JwtController {

    @Autowired
    private UserService userService;

    @RequestMapping("test")
    public String login(@RequestBody User user) {
        user = userService.login(user);
        String token = SignUtil.sign(user.getLoginName(), user.getId());
        return token;
    }

    @RequestMapping("user")
    public User selectUser(@RequestBody User user) {
        //这里查询User
        return user;
    }

}
