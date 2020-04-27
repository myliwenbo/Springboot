package vip.xjdai.demo;

public class toStringDemo {

    static class A{
        @Override
        public String toString() {
            System.out.print("I ");
            return "";
        }
    }

    public static void main(String[] args) {
        A a=new A();
        System.out.println("love you."+a);
    }
}
