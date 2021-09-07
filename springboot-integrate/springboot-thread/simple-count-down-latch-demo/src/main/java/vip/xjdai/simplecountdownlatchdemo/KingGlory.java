package vip.xjdai.simplecountdownlatchdemo;

import com.google.common.collect.Lists;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class KingGlory {

    private static CountDownLatch countDownLatch = new CountDownLatch(5);

    public static void main(String[] args) throws Exception {
        new Thread(new TXServer(countDownLatch)).start();
        ArrayList<Thread> threadArrayList = Lists.newArrayList();
        threadArrayList.add(new Thread(new Player(countDownLatch, "李白")));
        threadArrayList.add(new Thread(new Player(countDownLatch, "安其拉")));
        threadArrayList.add(new Thread(new Player(countDownLatch, "后羿")));
        threadArrayList.add(new Thread(new Player(countDownLatch, "赵云")));
        threadArrayList.add(new Thread(new Player(countDownLatch, "马超")));
        threadArrayList.forEach(Thread::start); // 启动线程
        for (Thread thread : threadArrayList) {
            thread.join();
        }

    }
}

class Player implements Runnable {
    private CountDownLatch countDownLatch;
    private String playerName;

    public Player(CountDownLatch countDownLatch, String playerName) {
        this.countDownLatch = countDownLatch;
        this.playerName = playerName;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(playerName + "：进入游戏开始读条");
        Thread.sleep(new Random().nextInt(5000));
        System.out.println(playerName + "：读条成功开始等他其他玩家");
        countDownLatch.countDown();
    }
}

class TXServer implements Runnable {
    private CountDownLatch countDownLatch;

    public TXServer(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("大家一起进入服务器");
        countDownLatch.await();
        System.out.println("加载成功大家一起开始愉快的战斗吧");
    }
}
