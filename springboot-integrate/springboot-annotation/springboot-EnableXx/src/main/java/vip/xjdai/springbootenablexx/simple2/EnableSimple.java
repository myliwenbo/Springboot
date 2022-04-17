package vip.xjdai.springbootenablexx.simple2;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(EanbleImportBeanDemo.class)
public @interface EnableSimple {
}
