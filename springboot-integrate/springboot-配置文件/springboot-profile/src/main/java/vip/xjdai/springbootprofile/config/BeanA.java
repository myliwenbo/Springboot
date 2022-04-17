package vip.xjdai.springbootprofile.config;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BeanA {

    private String s;

    public BeanA(String s) {
        this.s = s;
    }
}