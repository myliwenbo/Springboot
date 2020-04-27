package vip.xjdai.validation.increase;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;
import org.hibernate.validator.internal.constraintvalidators.bv.NotNullValidator;

import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class NotNullIncreaseValidator extends NotNullValidator {

    private NotNull notNull;

    public void initialize(NotNull notNull) {
        this.notNull = notNull;
    }

    @SneakyThrows
    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        boolean valid = super.isValid(object, constraintValidatorContext);
        if (valid) {
            return valid;
        }
        return false;
    }
}
