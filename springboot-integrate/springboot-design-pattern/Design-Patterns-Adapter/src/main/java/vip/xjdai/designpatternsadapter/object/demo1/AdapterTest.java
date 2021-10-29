package vip.xjdai.designpatternsadapter.object.demo1;

import vip.xjdai.designpatternsadapter.clazz.demo2.Source;
import vip.xjdai.designpatternsadapter.clazz.demo2.Targetable;

public class AdapterTest {

    public static void main(String[] args) {
        Source source = new Source();
        Targetable target = new Wrapper(source);
        target.method1();
        target.method2();
    }
}