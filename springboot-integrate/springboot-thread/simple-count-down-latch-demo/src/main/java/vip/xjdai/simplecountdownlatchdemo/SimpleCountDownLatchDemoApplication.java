package vip.xjdai.simplecountdownlatchdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class SimpleCountDownLatchDemoApplication {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            //lambda中只能只用final的变量
            final int times = i;
            new Thread(() -> {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在赶路");
                    Thread.sleep(10000 * times);
                    latch.countDown();
                    System.out.println("子线程" + Thread.currentThread().getName() + "到公司了");
                    //调用latch的countDown方法使计数器-1
                    System.out.println("子线程" + Thread.currentThread().getName() + "开始工作");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
