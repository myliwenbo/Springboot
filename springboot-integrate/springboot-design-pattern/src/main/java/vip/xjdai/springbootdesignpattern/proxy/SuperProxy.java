package vip.xjdai.springbootdesignpattern.proxy;

//父类
public class SuperProxy {
    public void method() {
        System.out.println("原始方法");
    }
}

//子类
class SupProxy extends SuperProxy {

    public void method() {
        System.out.println("对方法的增强");
        super.method();
        System.out.println("对方法的增强");
    }

    //测试
    public static void main(String[] args) {
        SuperProxy zl = new SupProxy();
        zl.method();
    }

}