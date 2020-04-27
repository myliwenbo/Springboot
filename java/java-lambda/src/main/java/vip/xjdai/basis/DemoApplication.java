package vip.xjdai.basis;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class DemoApplication
{

    @Test
    public void test1()
    {
        new Thread(new Runnable()
        {
            @SneakyThrows
            @Override
            public void run()
            {
                System.out.println("我匿名内部类");
                Thread.sleep(1000);
            }
        }).start();
        new Thread()
        {
            @SneakyThrows
            public void run()
            {
                System.out.println("我是构造函数执行了");
                Thread.sleep(1000);
            }
        }.start();
        new Thread(() -> {
            System.out.println("哎呀我执行了1");
        }).start();
        new Thread(() -> System.out.println("哎呀我执行了2")).start();
    }

    @Test
    public void test2()
    {

        LambdaInterface consumer = new LambdaInterface()
        {
            @Override
            public void sout(String s)
            {
                System.out.println(s);
            }
        };
        consumer.sout("哎呀我去");
        LambdaInterface consumer2 = (s) -> {
            System.out.println(s);
        };
        consumer2.sout("哎呀我去");
        LambdaInterface consumer3 = (s) -> System.out.println(s);
        consumer3.sout("哎呀我去");

    }

    @Test
    public void test3()
    {
        String[] s = { "1", "3", "2", };
        Arrays.sort(s, new Comparator< String >()
        {
            @Override
            public int compare(String o1, String o2)
            {
                return Integer.parseInt(o1) - Integer.parseInt(o2);
            }
        });
        System.out.println(Arrays.toString(s));
        //使用lambda
        Arrays.sort(s, (String p1, String p2) -> {
            return Integer.parseInt(p1) - Integer.parseInt(p2);
        });
        //优化
        Arrays.sort(s, (p1, p2) -> Integer.parseInt(p1) - Integer.parseInt(p2));
        System.out.println(Arrays.toString(s));
    }

}



/**
 * Lambda函数式接口
 */
@FunctionalInterface  //排除默认方法和继承Object方法
 interface LambdaInterface
{
    void sout(String s);
}
