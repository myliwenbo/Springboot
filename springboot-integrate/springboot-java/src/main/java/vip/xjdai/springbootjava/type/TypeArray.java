package vip.xjdai.springbootjava.type;

public class TypeArray {

    public static void main(String[] args) {
        NumberType<Integer>[] numberTypes = new NumberType[10];
        numberTypes[1] = new NumberType<Integer>();
        System.out.println(numberTypes[1]);
    }
}
