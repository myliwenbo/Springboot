package vip.xjdai.validation.increase;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.internal.engine.ValidatorFactoryImpl;

import javax.validation.ValidatorFactory;
import javax.validation.spi.ConfigurationState;
import java.lang.reflect.Field;

@Slf4j
public class CustomHibernateValidator extends HibernateValidator implements ICustomHibernateValidator {

    @Override
    public ValidatorFactory buildValidatorFactory(ConfigurationState configurationState) {
        ValidatorFactoryImpl validatorFactory = new ValidatorFactoryImpl(configurationState);
        IncreaseConstraintHelper customConstraintHelper = new IncreaseConstraintHelper();
        try {
            Field field = validatorFactory.getClass().getDeclaredField("constraintHelper");
            field.setAccessible(true);
            field.set(validatorFactory, customConstraintHelper);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            log.error("{}", e);
        }
        customConstraintHelper.moidfy();

        return validatorFactory;
    }
}
