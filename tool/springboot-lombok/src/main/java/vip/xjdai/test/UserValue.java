/**
 * 
 */
package vip.xjdai.test;

import static java.lang.System.out;

import lombok.Value;

//生成Getter、toString()、equals()、hashCode()以及一个全参的构造器
@Value
public class UserValue {

    private String name;
    private String password;
    private String sex;

    public static void main(String[] args) {
        UserValue user = new UserValue("123", "123", "123");
        out.println(user.getPassword());
        out.println(user.getName());
        out.println(user.toString());
    }

}
