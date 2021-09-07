/**
 * 
 */
package vip.xjdai.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lwb
 *
 */
@RestController
@RequestMapping
public class TestController {

    @RequestMapping("getUser")
    public String getUser()
    {
        return "ok";
    }

    @RequestMapping("getUserAll")
    public String getUserAll()
    {
        return "ok";

    }

    @RequestMapping("addUser")
    public String addUser()
    {
        return "ok";
    }

}
