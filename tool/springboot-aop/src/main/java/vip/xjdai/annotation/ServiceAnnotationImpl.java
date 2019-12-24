package vip.xjdai.annotation;

import org.springframework.stereotype.Service;

@Service
public class ServiceAnnotationImpl implements  ServiceAnnotation
{
    public static String test(){
        System.out.println("wwww");
        return "ok";
    }
}
