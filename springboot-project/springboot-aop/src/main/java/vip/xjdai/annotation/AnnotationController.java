package vip.xjdai.annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("annotation")
public class AnnotationController
{

    @RequestMapping("test")
    public String annotationTest() {
        return ServiceAnnotationImpl.test();
    }
}
