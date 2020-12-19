package vip.xjdai.springbootthreaddemo.Instruction;

public class Singleton {


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                Singleton instance = Singleton.getInstance();
                System.out.println("对象" + instance);
            });
            thread.start();
        }
    }

    private static Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}