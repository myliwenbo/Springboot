package vip.xjdai.designpatternssingleton;

public class SingletonSluggardThree{

    static class SingletonSluggardThreeCreate {
        static SingletonSluggardThree instance = new SingletonSluggardThree();
    }

    //在调用的时候才去初始化当前类，利用内部类和类加载机制
    public static SingletonSluggardThree getInstance() {
        return SingletonSluggardThreeCreate.instance;
    }

}
 