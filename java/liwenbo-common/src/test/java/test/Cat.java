package test;

import java.util.List;

import lombok.Data;

@Data
public class Cat {
    //名字    
    private String     name;
    //大小    
    private Integer    age;
    //玩具球  球具有颜色属性    
    private List<Ball> balls;

    Cat(String name, Integer age, List<Ball> balls) {
        this.name = name;
        this.age = age;
        this.balls = balls;
    }
}