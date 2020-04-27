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
@RequestMapping("xss")
public class XssController {

    @RequestMapping("xss")
    public void xxs() {
        System.out.println("aaaa");
        int i = 10 / 0;
    }
}
