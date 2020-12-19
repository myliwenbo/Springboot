package vip.xjdai.springbootthreadjava.thread.guard;


import org.junit.jupiter.api.Test;

public class GuardDemo {


    @Test
    public static void guard1() throws Exception {

        final Thread daemonTread = new Thread();
        // 设定 daemonThread 为 守护线程，default false (非守护线程)
        daemonTread.setDaemon(true);
        // 验证当前线程是否为守护线程，返回 true 则为守护线程
        final boolean daemon = daemonTread.isDaemon();
        System.out.println(daemon);

    }
}
