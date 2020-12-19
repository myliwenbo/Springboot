package vip.xjdai.springbootsynchronized.Test;

import lombok.SneakyThrows;

public class SynchronizedDemo {

    @SneakyThrows
    public synchronized void T1() {
        System.out.println("T1");
        Thread.sleep(10000);
    }

    @SneakyThrows
    public synchronized void T2() {
        System.out.println("T1");
        Thread.sleep(10000);

    }

    @SneakyThrows
    public void T3() {
        System.out.println("T3");
        Thread.sleep(10000);

    }

}
