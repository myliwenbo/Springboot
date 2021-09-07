package vip.xjdai.validationcustomize.increase;

import org.hibernate.validator.internal.constraintvalidators.bv.NotNullValidator;

import javax.validation.ConstraintValidatorContext;


public class NotNullValidatorIncrease extends NotNullValidator {

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        boolean valid = super.isValid(object, constraintValidatorContext);
        if (valid) {
            System.out.println("我覆盖了");
        }
        return true;
    }
}
