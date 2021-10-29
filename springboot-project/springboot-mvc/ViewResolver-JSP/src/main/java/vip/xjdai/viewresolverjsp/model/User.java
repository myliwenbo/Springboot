package vip.xjdai.viewresolverjsp.model;

import lombok.Data;

@Data
public class User {
    private String id;
    private String username;
    private int age;

    public User(String id, String username, int age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }
}
