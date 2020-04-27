
package vip.xjdai.annotation.springmvc;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lwb
 */

@RestController
@RequestMapping("sping/annotation")
public class SpringMvcAnnotation {

    @RequestMapping(value = "requestMapping/{id}", method = {RequestMethod.POST, RequestMethod.GET})
    public void requestMappingAnnotation(@PathVariable("id") String id, @RequestParam("order") String orderNo,
                                         @RequestParam String code) {
        System.out.println(id);
        System.out.println(orderNo);
        System.out.println(code);
    }
}
