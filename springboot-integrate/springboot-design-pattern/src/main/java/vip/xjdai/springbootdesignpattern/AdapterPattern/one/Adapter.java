package vip.xjdai.springbootdesignpattern.AdapterPattern.one;

public class Adapter extends Adaptee implements Target{
    @Override
    public void request() {
        //...一些操作...
        super.adapteeRequest();
        //...一些操作...
    }
}
