package vip.xjdai.demo.thread.guard;

import org.junit.Test;

public class GuardDemo {


    @Test
    public void guard1() throws Exception {

        Thread daemonTread = new Thread();
        // 设定 daemonThread 为 守护线程，default false (非守护线程)
        daemonTread.setDaemon(true);
        // 验证当前线程是否为守护线程，返回 true 则为守护线程
        boolean daemon = daemonTread.isDaemon();
        System.out.println(daemon);

    }
}
