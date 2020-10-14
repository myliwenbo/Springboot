package vip.xjdai.validation.difference.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
public class ValidPOJO extends BasePOJO {

    @NotBlank(message = "我丢你老母")
    private String name;
    private String age;

    @Valid
    private UserDetails userDetails;
}

