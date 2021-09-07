package vip.xjdai.validationcustomize.increase;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorDescriptor;

import javax.validation.ConstraintValidator;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
public class IncreaseConstraintHelper /*extends ConstraintHelper*/ {

    // public IncreaseConstraintHelper() {
    //     super();
    // }

    void moidfy() {
        Field builtinConstraints = null;
        try {
            builtinConstraints = this.getClass().getSuperclass().getDeclaredField("builtinConstraints");
            builtinConstraints.setAccessible(true);
            Object o = builtinConstraints.get(this);
            Map<Class<? extends Annotation>, List<ConstraintValidatorDescriptor<?>>> tmpConstraints = new HashMap<>();
            tmpConstraints.putAll((Map<? extends Class<? extends Annotation>, ? extends List<ConstraintValidatorDescriptor<?>>>) o);
            putConstraint(tmpConstraints, NotNull.class, NotNullValidatorIncrease.class);
            builtinConstraints.set(this, tmpConstraints);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            log.error("初始化自定义注解失败{}", e.getMessage());
        }

    }

    private static <A extends Annotation> void putConstraint(Map<Class<? extends Annotation>, List<ConstraintValidatorDescriptor<?>>> validators,
                                                             Class<A> constraintType, Class<? extends ConstraintValidator<A, ?>> validatorType) {
        validators.put(constraintType, Collections.singletonList(ConstraintValidatorDescriptor.forClass(validatorType, constraintType)));
    }
}
