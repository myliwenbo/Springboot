package vip.xjdai.springbootjava.data.String;

public class StringDemo {
    public static void main(String[] args) {
        String s = new String("name");
        String name = "name";
        System.out.println("name".intern());
    }
}
