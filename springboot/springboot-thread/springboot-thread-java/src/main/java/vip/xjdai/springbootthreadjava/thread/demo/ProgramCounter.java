package vip.xjdai.springbootthreadjava.thread.demo;

import lombok.SneakyThrows;

public class ProgramCounter {

    public static void main(String[] args) {
        ProgramCounter programCounter = new ProgramCounter();
        for (int i = 0; i < 5; i++) {
            new Thread(programCounter::test, i + "").start();
        }
    }


    public synchronized void test() {
        System.out.println("进入方法....");
        if (Integer.parseInt(Thread.currentThread().getName()) % 2 == 0) {
            try {
                Thread.currentThread().wait();
            } catch (InterruptedException e) {
                System.out.println("暂停出现异常");
            }
        } else {
            System.out.println("我是奇数线程");
            // Thread.currentThread().notifyAll();
        }
        System.out.println("执行完毕");
    }
}
