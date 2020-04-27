package vip.xjdai.singleton;

/**
 * 单例模式：懒汉
 */
public class SingletonSluggardOne {

    private static SingletonSluggardOne s;

    /**
     * 禁止创建对象
     */
    private SingletonSluggardOne() {
    }

    /**
     * 利用 同步方法的方式，处理掉这个BUG
     *
     * @return
     */
    public synchronized static SingletonSluggardOne createSingletonHungry() {
        if (s == null) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            s = new SingletonSluggardOne();
        }
        return s;
    }


    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(SingletonSluggardOne.createSingletonHungry().hashCode());
            }).start();
        }
    }
}
