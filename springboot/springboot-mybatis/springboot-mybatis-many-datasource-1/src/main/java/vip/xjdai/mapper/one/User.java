package vip.xjdai.mapper.one;

public class User {
    private Integer userId;

    private String userName;

    private String password;

    private String tbPhone;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTbPhone() {
        return tbPhone;
    }

    public void setTbPhone(String tbPhone) {
        this.tbPhone = tbPhone;
    }
}