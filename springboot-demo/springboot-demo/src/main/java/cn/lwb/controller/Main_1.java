package cn.lwb.controller;

public class Main_1 {

    @SuppressWarnings("unlikely-arg-type")
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;
        System.out.println(c == d); //true
        System.out.println(e == f); //false 为啥是false，因为超过-128和127就已经超出缓冲区了
        System.out.println(c == (a + b));//true
        System.out.println(c.equals(a + b));//true
        System.out.println(g == (a + b));//true
        System.out.println(g.equals(a + b));
        System.out.println(g.equals(a + h));
    }

}