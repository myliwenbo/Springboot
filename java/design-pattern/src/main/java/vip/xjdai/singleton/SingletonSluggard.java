package vip.xjdai.singleton;

/**
 * 单例模式：懒汉
 */
public class SingletonSluggard {

    private static SingletonSluggard s;

    /**
     * 禁止创建对象
     */
    private SingletonSluggard() {
    }

    /**
     * 获取的时候，如果为null 的时候才去创建，有一个BUG
     * 1. 假设创建一个对象需要1秒..那去获取对象的时候就是不一样...
     *
     * @return
     */
    public static SingletonSluggard createSingletonHungry() {
        if (s == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            s = new SingletonSluggard();
        }
        return s;
    }


    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100; i++) {
           new Thread(() -> {
            }).start();
        }
    }
}
