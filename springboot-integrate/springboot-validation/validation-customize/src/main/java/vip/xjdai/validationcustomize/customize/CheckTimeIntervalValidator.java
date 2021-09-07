
package vip.xjdai.validationcustomize.customize;

import lombok.Data;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

@Data
public class CheckTimeIntervalValidator implements
        ConstraintValidator<CheckTimeInterval, Object> {

    private String startTime;

    private String endTime;

    /**
     * 获取注解
     * @param checkTimeInterval
     */
    @Override
    public void initialize(CheckTimeInterval checkTimeInterval) {
        this.endTime = checkTimeInterval.endime();
        this.startTime = checkTimeInterval.startTime();
    }

    /**
     * 校验内容
     * @param value
     * @param context
     * @return
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        //true 表示通过
        //false 表示错误
        if (value == null) {
            return true;
        }
        BeanWrapper beanWrapper = new BeanWrapperImpl(value);
        Object endTime = beanWrapper.getPropertyValue(this.endTime);
        Object startTime = beanWrapper.getPropertyValue(this.startTime);
        if (endTime == null || startTime == null) {
            // context.disableDefaultConstraintViolation();//禁用默认消息
            // context.buildConstraintViolationWithTemplate("啊参数不能为空") //设置消息
            //         .addConstraintViolation();//添加约束信息
            return false;
        }
        int result = ((Date) endTime).compareTo((Date) startTime);
        if (result >= 0) {
            return true;
        }
        return false;
    }

}
