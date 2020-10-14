package vip.xjdai.constant;

public abstract class ExtendsDemo {

    /**
     *
     */
    protected void test() {
        System.out.println("我是Extends");
    }

    public static class ExtendsDemo1 extends ExtendsDemo {

        @Override
        public void test() {
            System.out.println("我是ExtendsDemo1");
            super.test();
        }
    }

    public static class ExtendsDemo2 extends ExtendsDemo1 {

        @Override
        public void test() {
            System.out.println("我是ExtendsDemo2");
            super.test();
        }
    }

    public static void main(String[] args) {
        ExtendsDemo2 extendsDemo2 = new ExtendsDemo2();
        extendsDemo2.test();
    }
}
