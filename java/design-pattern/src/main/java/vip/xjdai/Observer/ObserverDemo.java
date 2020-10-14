package vip.xjdai.Observer;

public class ObserverDemo {

    public static void main(String[] args) {

        ConcreteIdo ido = new ConcreteIdo("蔡徐坤");
        // 添加粉丝，这里如果套用 事件的话这里就是发布了一个事件那谁去消费这个事件呢？
        ido.addFan(new ConcreteFan("张三1"));
        ido.addFan(new ConcreteFan("张三2"));
        ido.addFan(new ConcreteFan("张三3"));
        ido.addFan(new ConcreteFan("张三4"));
        ido.notyfi("唱跳"); //去消费这个事件
    }
}

//