package vip.xjdai.source;

public class ArrayListDemo
{

    public static void main(String[] args)
    {

        Object key = new Object();
        int    h;
        if (key == null) {
            System.out.println(0);
        } else {
            System.out.println(h = key.hashCode());
            System.out.println(Integer.toBinaryString(h));
            int ii = h >>> 16;
            System.out.println(Integer.toBinaryString(ii));
            System.out.println(h ^ ii);
            //1000010111101101111001111011
            //0000000000000000100001011110
            //1000010111101101011000100101
            System.out.println(Integer.valueOf("1000010111101101011000100101",2).toString());
        }
    }
}
