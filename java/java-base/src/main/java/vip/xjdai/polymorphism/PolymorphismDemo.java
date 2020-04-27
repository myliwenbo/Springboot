package vip.xjdai.polymorphism;

public class PolymorphismDemo extends PolymorphismFather
{
    @Override
    public String toString()
    {
        return "PolymorphismDemo{}";
    }

    public static void main(String[] args)
    {
        Object o=new PolymorphismDemo();
        System.out.println(o.toString());
    }
}
