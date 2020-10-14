package vip.xjdai.stack;

public class toStringDemo {

    static class A {

        @Override
        public String toString() {
            System.out.print("I ");
            return "";
        }
    }

    /**
     * 演示 对象打印的时候会先去调用toString方法
     *
     * @param args
     */
    public static void main(String[] args) {
        A a = new A();
        System.out.println("love you." + a);
    }
}
