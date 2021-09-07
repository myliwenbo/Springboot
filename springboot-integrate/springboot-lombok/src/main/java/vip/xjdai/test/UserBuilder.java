/**
 * 
 */
package vip.xjdai.test;

import lombok.Builder;
import lombok.ToString;

/**
 * @author lwb
 *
 */
// Setter、Getter、toString（）、equals() 和 hashCode()。
@Builder
@ToString
public class UserBuilder {

    private String name;
    private String password;
    private String sex;

    public static void main(String[] args) {
        UserBuilder user = new UserBuilder("小明", "123", "男");
        UserBuilderBuilder sex2 = UserBuilder.builder().name("小明").password("123")
            .sex("男");
        System.out.println(user.toString());
        System.out.println(sex2.toString());

    }

}
