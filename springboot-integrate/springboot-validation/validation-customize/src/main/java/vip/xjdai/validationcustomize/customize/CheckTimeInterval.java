/**
 *
 */
package vip.xjdai.validationcustomize.customize;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author lwb
 *
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = {CheckTimeIntervalValidator.class})
//表示该注解可以在同一个地方多次使用
@Repeatable(CheckTimeInterval.List.class)
public @interface CheckTimeInterval {

    /**
     * 参数，默认自动为 from
     * @return
     */
    String startTime() default "from";

    /**
     * 参数，默认自动为 to
     * @return
     */
    String endime() default "to";

    /**
     * 默认信息为：时间不正确啦
     * @return
     */
    String message() default "{javax.validation.constraints.NotBlank.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * 用于容纳 CheckTimeInterval的容器
     * @author lwb
     *
     */
    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    public @interface List {
        CheckTimeInterval[] value();
    }
}
