package vip.xjdai.springbootenablexx.ImportSelector;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(EmableImportSelectorConfig.class)
public @interface EanbleImportSelector {

    Class<?>[] value() default {};

}
