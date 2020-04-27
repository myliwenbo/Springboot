package vip.xjdai.validation.increase;


import org.hibernate.validator.internal.constraintvalidators.bv.NullValidator;

import javax.validation.ConstraintValidatorContext;


/**
 *  没有效果!!!
 */
public class NullValidatorIncrease extends NullValidator  {

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {

        boolean valid = super.isValid(object, constraintValidatorContext);

        System.out.println("我执行了");

        return false;
    }


}
