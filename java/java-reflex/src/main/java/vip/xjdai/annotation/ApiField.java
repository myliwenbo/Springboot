package vip.xjdai.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 表示注解在运行时依然存在
@Target({ElementType.METHOD, ElementType.TYPE})  // 表示注解可以被使用于方法上
public @interface ApiField {

    String paramValue() default "johness";
}
