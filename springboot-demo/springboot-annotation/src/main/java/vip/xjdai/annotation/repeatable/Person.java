package vip.xjdai.annotation.repeatable;

import java.lang.annotation.Repeatable;

@Repeatable(value = Persons.class)
public @interface Person {

    String role() default "";
}