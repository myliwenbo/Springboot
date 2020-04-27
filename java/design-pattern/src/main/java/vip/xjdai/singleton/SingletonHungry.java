package vip.xjdai.singleton;

/**
 * 单例模式：饿汉式
 */
public class SingletonHungry {

    private static final SingletonHungry s = new SingletonHungry();

    /**
     * 禁止创建对象
     */
    private SingletonHungry() {
    }

    public SingletonHungry createSingletonHungry() {
        return s;
    }
}
