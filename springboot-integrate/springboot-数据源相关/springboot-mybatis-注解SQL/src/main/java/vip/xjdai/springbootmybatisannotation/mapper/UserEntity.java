package vip.xjdai.springbootmybatisannotation.mapper;

import lombok.Data;

@Data
public class UserEntity {

    private Long id;
    private String userName;
    private String passWord;
    private UserSexEnum userSex;
    private String nickName;

    public UserEntity() {
        super();
    }

    public UserEntity(String userName, String passWord, UserSexEnum userSex) {
        super();
        this.passWord = passWord;
        this.userName = userName;
        this.userSex = userSex;
    }

}
