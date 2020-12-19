package vip.xjdai.springbootthreadjava.Utils;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch value = new CountDownLatch(1);
        value.countDown();
        value.await();

    }
}
