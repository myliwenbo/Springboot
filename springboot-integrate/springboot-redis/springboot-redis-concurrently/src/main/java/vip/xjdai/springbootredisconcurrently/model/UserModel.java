package vip.xjdai.springbootredisconcurrently.model;

import lombok.Data;

@Data
public class UserModel {

    private static UserModel value = new UserModel();

    private String userName;

    public static UserModel mysqlModelUser(String key) {
        value.setUserName(key);
        return value;
    }
}
