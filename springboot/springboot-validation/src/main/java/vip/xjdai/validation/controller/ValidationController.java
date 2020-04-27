/**
 *
 */
package vip.xjdai.validation.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.validation.pojo.LoginForm;

import javax.validation.Valid;

/**
 * @author lwb
 *
 */
@RestController
@RequestMapping("validationController")
public class ValidationController {

    /**
     * 在这里使用   @Valid 这个类中的规则才会生效，否则不会生效
     * @param loginForm
     * @return
     */
    @RequestMapping("validationController")
    public String validationController(@RequestBody @Valid LoginForm loginForm) {
        return "ok";

    }

}
