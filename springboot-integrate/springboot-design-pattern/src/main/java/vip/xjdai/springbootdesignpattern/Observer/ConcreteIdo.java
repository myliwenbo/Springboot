package vip.xjdai.springbootdesignpattern.Observer;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ConcreteIdo implements Idol {
    private List<Fan> fans = new ArrayList<>();
    private String name;

    public ConcreteIdo(String name) {
        this.name = name;
    }

    @Override
    public void addFan(Fan fan) {
        fans.add(fan);
    }

    @Override
    public void deFan(Fan fan) {
        fans.remove(fan);
    }

    @Override
    public void notyfi(String message) {
        for (Fan fam : fans) {
            fam.updata("蔡徐坤："+message);
        }
    }
}
