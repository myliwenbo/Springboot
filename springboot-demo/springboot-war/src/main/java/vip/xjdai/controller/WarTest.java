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
@RequestMapping("test")
public class WarTest {

    @RequestMapping("test")
    public String test() {
        return "OK";
    }
}
