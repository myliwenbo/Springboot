package vip.xjdai.simplejavademo.test;

public class ThreadTest03 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            int i = 0;

            @Override
            public void run() {
                while (true && !this.isInterrupted()) {
                    System.out.println(this.i++);
                }

            }
        };
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
        System.out.println(thread.getState());
    }
}
