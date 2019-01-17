package cn.lwb.spirng.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class User extends UserSuper {
    private String sex;

}
