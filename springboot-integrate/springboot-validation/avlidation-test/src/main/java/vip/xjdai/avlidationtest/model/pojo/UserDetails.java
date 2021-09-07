package vip.xjdai.avlidationtest.model.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserDetails extends BasePOJO {

    @NotNull(message = "地址不能为空", groups = {BasePOJO.Add.class})
    private String address;

}
