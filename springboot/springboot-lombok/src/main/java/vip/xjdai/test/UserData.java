/**
 * 
 */
package vip.xjdai.test;

import static java.lang.System.out;

import lombok.Data;

/**
 * @author lwb
 *
 */
// Setter、Getter、toString（）、equals() 和 hashCode()。
@Data
public class UserData {

    private String name;
    private String password;
    private String sex;

    public static void main(String[] args) {
        UserData user = new UserData();
        user.setName("123");
        user.setPassword("123");
        out.println(user.getPassword());
        out.println(user.getName());
        out.println(user.toString());
    }

}
