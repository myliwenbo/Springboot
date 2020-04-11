/**
 *
 */
package vip.xjdai.validation.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

/**
 * @author lwb
 *
 */
@Data
//默认校验
public class LoginForm {


    private String name;

    @Null(message = "我不能为kong")
    private String password;

    private Long couponId;

    private Date from;

    private Date to;

    private Date start;

    private Date end;

}
