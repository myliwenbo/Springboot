package vip.xjdai.springbootvalid.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class User {
    @NotBlank
    private String name;
    @NotBlank
    private String password;

}
