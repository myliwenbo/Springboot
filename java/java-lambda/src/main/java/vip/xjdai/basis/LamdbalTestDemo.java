package vip.xjdai.basis;

import java.util.function.Supplier;

public class LamdbalTestDemo
{
    public static void main(String[] args)
    {
        print1("hello,world");
        print2(new Supplier< String >()
        {
            @Override
            public String get()
            {
                return "hello world";
            }
        });
        print2(() -> {
            return "hello world";
        });
        print2(() -> "hello world");
    }

    private static void print1(String s)
    {
        System.out.println(s);
    }

    private static void print2(Supplier< String > message)
    {
        System.out.println(message.get());
    }
}
