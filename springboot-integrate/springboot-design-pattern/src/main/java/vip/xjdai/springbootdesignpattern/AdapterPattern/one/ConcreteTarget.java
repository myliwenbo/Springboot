package vip.xjdai.springbootdesignpattern.AdapterPattern.one;


/**
 * 怎么才可以在目标接口中的 {@link ConcreteTarget}.request() 调用
 * {@link Adaptee}.adapteeRequest() 这个方法呢？
 */
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("concreteTarget目标方法");
    }
}
