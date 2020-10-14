package cvip.xjdai;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class SpringApiApplication
{

    public static void main(String[] args)

    {
        AnnotationMetadata introspect = AnnotationMetadata.introspect(SpringApiApplication.class);
        //annotations


        System.out.println(JSON.toJSONString(introspect));
        //        SpringApplication.run(SpringApiApplication.class, args);
    }

}
