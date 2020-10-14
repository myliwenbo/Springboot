package vip.xjdai.validation.customize;

import lombok.Data;

import java.util.Date;

@Data
// @CheckTimeInterval(message = "默认参数错误") //默认自动，自定义注解
@CheckTimeInterval(endime = "start", startTime = "start", message = "自定义参数")//自定义注解
public class LoginForm {

    private Date from;
    private Date to;

    private Date start;
    private Date end;
}