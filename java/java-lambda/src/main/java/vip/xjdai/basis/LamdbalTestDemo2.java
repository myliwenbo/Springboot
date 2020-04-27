package vip.xjdai.basis;

public class LamdbalTestDemo2
{

    public static void main(String[] args)
    {
        start(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("我是匿名内部类");
            }
        });
        start(() -> System.out.println("我是函数式接口"));
    }

    public static void start(Runnable runnable)
    {
        new Thread(runnable).start();
    }

}
