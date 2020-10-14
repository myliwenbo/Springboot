package vip.xjdai.annotation.ManagedBean;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Aspect {

    /**
     * @return the per clause expression, defaults to singleton aspect.
     * Valid values are "" (singleton), "perthis(...)", etc
     */
    public String value() default "";
}
