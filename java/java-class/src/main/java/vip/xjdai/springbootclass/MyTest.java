package vip.xjdai.springbootclass;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MyTest {

    String memberValues() default "";
}
