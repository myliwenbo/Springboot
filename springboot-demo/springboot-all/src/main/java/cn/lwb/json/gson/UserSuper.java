package cn.lwb.json.gson;

public class UserSuper {

    private String name;

    private String age;

    private String jsonInclude;

    private String sssssssss;

    private String password;

    private String md5Password;

    private String secretKey;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getJsonInclude() {
        return jsonInclude;
    }

    public void setJsonInclude(String jsonInclude) {
        this.jsonInclude = jsonInclude;
    }

    public String getMd5Password() {
        return md5Password;
    }

    public void setMd5Password(String md5Password) {
        this.md5Password = md5Password;
    }

    public String getSssssssss() {
        return sssssssss;
    }

    public void setSssssssss(String sssssssss) {
        this.sssssssss = sssssssss;
    }

    @Override
    public String toString() {
        return "UserSuper [name=" + name + ", age=" + age + ", jsonInclude=" + jsonInclude
               + ", sssssssss=" + sssssssss + ", password=" + password + ", md5Password="
               + md5Password + ", secretKey=" + secretKey + "]";
    }

}
