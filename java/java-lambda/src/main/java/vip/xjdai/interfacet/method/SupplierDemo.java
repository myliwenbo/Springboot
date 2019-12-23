package vip.xjdai.interfacet.method;

import java.util.function.Supplier;

public class SupplierDemo
{
    public static void main(String[] args)
    {
        Supplier< String > s = new Supplier< String >()
        {
            @Override
            public String get()
            {
                return "null";
            }
        };
        System.out.println(s.get());
        Supplier< String > s1 = () -> {
            return "S1null";
        };
        System.out.println(s1.get());
        Supplier< String > s2 = () -> "S2null";
        System.out.println(s2.get());
    }
}
