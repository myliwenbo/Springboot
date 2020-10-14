package vip.xjdai.list.pojo;

import lombok.Data;

@Data
public class User {


    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Default user name.
     */
    private String name;

    private Integer age;

}