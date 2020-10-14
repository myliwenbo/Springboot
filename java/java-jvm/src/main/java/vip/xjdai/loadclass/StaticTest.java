package vip.xjdai.loadclass;

public class StaticTest {

    static {   //静态代码块
        System.out.println("1");
    }
    static StaticTest st = new StaticTest();



    static int b = 112;     // 静态变量

            int a = 110;    // 实例变量

    {       // 实例代码块
        System.out.println("2");
    }

    public static void main(String[] args) {
        staticFunction();
    }

    StaticTest() {    // 实例构造器
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {   // 静态方法
        System.out.println("4");
    }

}