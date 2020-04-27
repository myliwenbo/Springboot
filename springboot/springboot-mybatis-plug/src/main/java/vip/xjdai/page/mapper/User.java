package vip.xjdai.page.mapper;

public class User {
    private Integer userId;

    private String  userName;

    private String  password;

    private String  phone;

    public User() {
        super();
    }

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
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public User(Integer userId, String userName, String password, String phone) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
    }
}
