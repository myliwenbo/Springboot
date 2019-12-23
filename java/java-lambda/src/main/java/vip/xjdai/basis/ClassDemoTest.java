package vip.xjdai.basis;

public class ClassDemoTest
{

    public static void main(String[] args)
    {
        new ClassDemoTest()
        {
            public void test()
            {
                System.out.println("测试");
            }
        }.test();

    }

}
