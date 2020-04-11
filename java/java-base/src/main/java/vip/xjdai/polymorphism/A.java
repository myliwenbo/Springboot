package vip.xjdai.polymorphism;

public class A {
    public String show(D obj) {

        return ("A and D");
    }
 
    public String show(A obj)
    {
        return ("A and A");
    } 
 
}
class Test {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();  //这里this 的指向是A
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println("1--" + a1.show(b)); // A and A 为什么?没有为什么..
        System.out.println("2--" + a1.show(c)); // A and A 为什么?因为C继承了B，B继承了A
        System.out.println("3--" + a1.show(d)); // A and D 为什么?没有为什么..
        System.out.println("4--" + a2.show(b)); // B and A
        // 1. a2是A类型的引用变量，所以this就代表了 A
        // 2. 由于this代表了A，所以先去找A类中查找有没有该方法 a2.show(c)，
        // 3. 由于没有找到入参为C的方法，但是找到了C的超类，
        // 4. 按说应该会调用 A 类中的方法，但是
        // 5. 由于 a2 代表了B类的引用，同时也从写了父类的 这个方法，
        // 6. 所以会调用的是
        System.out.println("5--" + a2.show(c)); // B and A
        System.out.println("6--" + a2.show(d)); // A and D 为什么? 因为B对象没有入参为D的方法，所以执行的是父类的方法
        System.out.println("7--" + b.show(b));  // B and B 为什么?没有为什么..
        System.out.println("8--" + b.show(c));  // B and B 为什么? 因为A对象和B对象都没有这个函数，但是C对象继承了B 所有可以理解C就是B
        System.out.println("9--" + b.show(d));  // A and D 为什么? 因为B对象没有方法入参为 D 的方法
        //参考： https://blog.csdn.net/newchitu/article/details/90380094
    }
}
 class B extends A{
    public String show(B obj){
        return ("B and B");
    }
    public String show(A obj){
        return ("B and A");
    } 
}
 
class C extends B{
 
}
 
class D extends B{
 
}
 
