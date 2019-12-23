package vip.xjdai.interfacet.method;

import java.util.Optional;
import java.util.function.Function;

public class FunctionDemo
{
    public static void change(String str, Function<String,Integer> function){
        //  Integer i = function.apply(str);
        //  自动拆箱 Integer自动转为int
        int i = function.apply(str);
        System.out.println(i);
    }

    public static void main(String[] args) {
        String s = "1234";
        change(s, new Function< String, Integer >() {
            @Override
            public Integer apply(String s)
            {
                return Integer.parseInt(s);
            }
        });
        change(s,str->{

            return 1;
        });

        int i = Integer.parseInt(s);
        System.out.println(i);
    }
}
