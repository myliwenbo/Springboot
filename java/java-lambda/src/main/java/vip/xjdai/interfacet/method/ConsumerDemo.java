package vip.xjdai.interfacet.method;

import java.util.function.Consumer;

public class ConsumerDemo
{
    public static void method(String name, Consumer<String> consumer){
        consumer.accept(name);
    }

    public static void main(String[] args) {
        method("小哇", new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("s是："+s);
            }
        });

        method("小哇",(name)->{
            String s = new StringBuffer(name).reverse().toString();
            System.out.println("s是："+s);
        });
    }
}
