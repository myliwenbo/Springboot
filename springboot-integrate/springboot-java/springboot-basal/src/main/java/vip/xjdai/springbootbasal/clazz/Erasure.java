package vip.xjdai.springbootbasal.clazz;

import lombok.Data;

@Data
public class Erasure<T> {
    private T hello;

    public Erasure(T hello) {
        this.hello = hello;
    }
}
