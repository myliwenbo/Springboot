package vip.xjdai.springbootenablexx.simple3;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(EanbleImportBean.class)
public @interface EnableSimple2 {
}
