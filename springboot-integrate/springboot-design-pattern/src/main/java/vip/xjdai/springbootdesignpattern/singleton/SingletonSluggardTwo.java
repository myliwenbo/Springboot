package vip.xjdai.springbootdesignpattern.singleton;

/**
 * 单例模式：懒汉
 */
public class SingletonSluggardTwo {

    private static SingletonSluggardTwo s;

    /**
     * 禁止创建对象
     */
    private SingletonSluggardTwo() {
    }

    /**
     * 利用 同步方法的方式，处理掉这个BUG
     *
     * @return
     */
    public static SingletonSluggardTwo createSingletonHungry() {
        if (s == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (SingletonSluggardOne.class) {
                s = new SingletonSluggardTwo();
            }
        }
        return s;
    }


    public static void main(String[] args) throws Exception {
//        for (int i = 0; i < 100; i++) {
//            new Thread(() -> {
//                System.out.println(SingletonSluggardTwo.createSingletonHungry().hashCode());
//            }).start();
//        }

        System.out.println(Integer.valueOf("1000000000000000000000000000000",2).toString());
    }
}
