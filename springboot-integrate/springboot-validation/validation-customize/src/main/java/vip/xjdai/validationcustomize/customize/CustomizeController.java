package vip.xjdai.validationcustomize.customize;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("customizeController")
public class CustomizeController {

    /**
     * 在这里使用   @Valid 这个类中的规则才会生效，否则不会生效
     *
     * @param loginForm
     * @return
     */
    @PostMapping(value = "validationController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String validationController(@RequestBody @Valid LoginForm loginForm) {
        return "ok";

    }
}
