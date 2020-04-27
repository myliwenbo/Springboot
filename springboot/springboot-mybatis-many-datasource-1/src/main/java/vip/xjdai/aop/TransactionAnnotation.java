package vip.xjdai.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
public @interface TransactionAnnotation {

    TransactionEnum[] value() default {};

    /**
     * 事物枚举类
     */
    public enum TransactionEnum {
        ONETransaction("oneTransactionManager"),
        TWOTransaction("twoTransactionManager");
        private String name;

        private TransactionEnum(String name) {
            this.name = name;
        }
    }

}
