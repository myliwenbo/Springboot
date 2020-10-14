package vip.xjdai.Observer;

import lombok.Data;

@Data
public class ConcreteFan implements Fan {
    private String name;

    public ConcreteFan(String name) {
        this.name = name;
    }

    @Override
    public void updata(String message) {
        System.out.println("我是" + this.name + "接收到了" + message);
    }
}
