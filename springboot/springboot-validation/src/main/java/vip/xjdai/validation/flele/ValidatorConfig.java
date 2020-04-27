package vip.xjdai.validation.flele;

import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.internal.engine.ValidatorFactoryImpl;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorDescriptor;
import org.hibernate.validator.internal.metadata.core.ConstraintHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vip.xjdai.validation.increase.NotNullIncreaseValidator;
import vip.xjdai.validation.increase.NotNullValidatorIncrease;
import vip.xjdai.validation.increase.NullValidatorIncrease;

import javax.validation.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ValidatorConfig {

    //默认会校验完所有属性，然后将错误信息一起返回，但很多时候不需要这样，一个校验失败了，其它就不必校验了
    @Bean
    public Validator test() throws Exception {
        ValidatorFactoryImpl validatorFactory = (ValidatorFactoryImpl) Validation
                .byProvider(HibernateValidator.class).configure().failFast(true)
                .buildValidatorFactory();
        Field constraintHelperField = validatorFactory.getClass().getDeclaredField("constraintHelper");
        constraintHelperField.setAccessible(true);
        ConstraintHelper constraintHelper = (ConstraintHelper) constraintHelperField.get(validatorFactory);
        getConstraintHelper(constraintHelper);
        constraintHelperField.set(validatorFactory, constraintHelper);
        Validator validator = validatorFactory.getValidator();
        return validator;
    }

    private void getConstraintHelper(ConstraintHelper constraintHelper) throws Exception {
        Field builtinConstraints = constraintHelper.getClass().getDeclaredField("builtinConstraints");
        builtinConstraints.setAccessible(true);
        Map<Class<? extends Annotation>, List<ConstraintValidatorDescriptor<?>>> tmpConstraints = new HashMap<>();
        tmpConstraints.putAll((Map<Class<? extends Annotation>, List<ConstraintValidatorDescriptor<?>>>) builtinConstraints.get(constraintHelper));
        putConstraint(tmpConstraints, Null.class, NullValidatorIncrease.class);
        builtinConstraints.set(constraintHelper, tmpConstraints);
    }

    private static <A extends Annotation> void putConstraint(Map<Class<? extends Annotation>, List<ConstraintValidatorDescriptor<?>>> validators,
                                                             Class<A> constraintType, Class<? extends ConstraintValidator<A, ?>> validatorType) {
        validators.put(constraintType, Collections.singletonList(ConstraintValidatorDescriptor.forClass(validatorType, constraintType)));
    }
}