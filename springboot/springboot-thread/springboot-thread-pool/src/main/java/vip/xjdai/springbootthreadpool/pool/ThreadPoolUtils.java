package vip.xjdai.springbootthreadpool.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUtils {

    public static ThreadPoolExecutor getThreadPoll() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1,
                2,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10));
        return threadPoolExecutor;

    }

}
