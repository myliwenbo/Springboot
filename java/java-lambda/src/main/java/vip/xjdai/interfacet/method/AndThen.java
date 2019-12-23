package vip.xjdai.interfacet.method;

import java.util.function.Consumer;

public class AndThen
{
    public static void method(String s, Consumer< String > consumer1, Consumer< String > consumer2)
    {
        consumer1.accept(s);
        consumer2.accept(s);
        //使用andThen方法,把两个Consumer接口连接到一起,在消费数据
        //con1连接con2,先执行con1消费数据,在执行con2消费数据
        consumer1.andThen(consumer2).accept(s);
    }

    public static void main(String[] args)
    {

        method("Hello", new Consumer< String >()
        {
            @Override
            public void accept(String s)
            {
                System.out.println(s.toUpperCase());
            }
        }, new Consumer< String >()
        {
            @Override
            public void accept(String s1)
            {
                System.out.println(s1.toUpperCase());
            }
        });
        method("Hello", (t) -> System.out.println(t.toUpperCase()), //消费方式:把字符串转换为大写输出
               (t) -> System.out.println(t.toLowerCase()));//消费方式:把字符串转换为小写输出

    }
}
