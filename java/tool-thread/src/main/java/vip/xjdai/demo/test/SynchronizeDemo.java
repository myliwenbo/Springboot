package vip.xjdai.demo.test;

/**
 * 同步Demo
 */
public class SynchronizeDemo
{

    public static void main(String[] args)
    {
        A();
        B();
    }

    public static void A()
    {
        System.out.println("A方法执行了");
    }

    public static void B()
    {
        System.out.println("B方法执行了");
    }

}
