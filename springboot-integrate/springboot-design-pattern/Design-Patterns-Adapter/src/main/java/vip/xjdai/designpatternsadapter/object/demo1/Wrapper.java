package vip.xjdai.designpatternsadapter.object.demo1;

import vip.xjdai.designpatternsadapter.clazz.demo2.Source;
import vip.xjdai.designpatternsadapter.clazz.demo2.Targetable;

public class Wrapper implements Targetable {

    private Source source;

    public Wrapper(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }

    @Override
    public void method1() {
        source.method1();
    }
}

