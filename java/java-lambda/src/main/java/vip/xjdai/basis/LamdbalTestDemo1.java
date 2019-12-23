package vip.xjdai.basis;

public class LamdbalTestDemo1
{
    public static void main(String[] args)
    {
        //定义三个日志信息
        String msg1 = "Hello";
        String msg2 = "World";
        String msg3 = "Java";
        showLog(2, msg1 + msg2 + msg3);
        //使用Lambda表达式作为参数传递,仅仅是把参数传递到showLog方法中，只有满足条件,日志的等级是1级才会调用接口MessageBuilder中的方法builderMessage，才会进行字符串的拼接；
        //如果条件不满足,日志的等级不是1级，那么MessageBuilder接口中的方法builderMessage也不会执行，所以拼接字符串的代码也不会执行，所以不会存在性能的浪费
        showLog(1, new MessageBuilder()
        {
            @Override
            public String builderMessage()
            {
                System.out.println("不满足条件不执行");
                //返回一个拼接好的字符串
                return msg1 + msg2 + msg3;
            }
        });
        showLog(2, msg1 + msg2 + msg3);
        //使用Lambda表达式作为参数传递,仅仅是把参数传递到showLog方法中，只有满足条件,日志的等级是1级才会调用接口MessageBuilder中的方法builderMessage，才会进行字符串的拼接；
        //如果条件不满足,日志的等级不是1级，那么MessageBuilder接口中的方法builderMessage也不会执行，所以拼接字符串的代码也不会执行，所以不会存在性能的浪费
        showLog(1, () -> {
            System.out.println("不满足条件不执行");
            //返回一个拼接好的字符串
            return msg1 + msg2 + msg3;
        });
    }


    //定义一个显示日志的方法,方法的参数传递日志的等级和MessageBuilder接口
    public static void showLog(int level, MessageBuilder mb)
    {
        //对日志的等级进行判断,如果是1级,则调用MessageBuilder接口中的builderMessage方法
        if (level == 1) {
            System.out.println(mb.builderMessage());
        }
    }

    //定义一个根据日志的级别,显示日志信息的方法
    public static void showLog(int level, String message)
    {
        //对日志的等级进行判断,如果是1级别,那么输出日志信息
        if (level == 1) {
            System.out.println(message);
        }
    }
}

@FunctionalInterface
interface MessageBuilder
{
    //定义一个拼接消息的抽象方法,返回被拼接的消息
    public abstract String builderMessage();
}