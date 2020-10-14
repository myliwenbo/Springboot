package vip.xjdai.validation.difference.pojo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserPOJO extends BasePOJO {

    @NotBlank(message = "Id不能为空", groups = {Add.class, Update.class})
    private String id;
    @NotBlank(message = "名称不能为空", groups = {Add.class})
    private String name;

    @NotBlank(message = "age不能为空")
    private String age;


}
