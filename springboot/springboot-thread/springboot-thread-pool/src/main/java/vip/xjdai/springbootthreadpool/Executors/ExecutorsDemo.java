package vip.xjdai.springbootthreadpool.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newScheduledThreadPool(10);
    }
}
