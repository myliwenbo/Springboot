package vip.xjdai.demo;

public class StrongReferenceDemo {

    private Integer i;

    public StrongReferenceDemo(Integer i) {
        this.i = i;
    }

    @Override
    public void finalize() {
        System.out.println("我被销毁啦" + this.toString());
    }

    @Override
    public String toString() {
        return "我是第几个i=" + i;
    }
}
