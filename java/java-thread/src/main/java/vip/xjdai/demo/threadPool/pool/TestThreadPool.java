package vip.xjdai.demo.threadPool.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {
 
	//定长线程池，每当提交一个任务就创建一个线程，直到达到线程池的最大数量，这时线程数量不再变化，当线程发生错误结束时，线程池会补充一个新的线程
	static ExecutorService fixedExecutor = Executors.newFixedThreadPool(2);
	
	
	public static void main(String[] args) {
		testFixedExecutor();
	}
	
	//测试定长线程池，线程池的容量为3，提交6个任务，根据打印结果可以看出先执行前3个任务，3个任务结束后再执行后面的任务
	private static void testFixedExecutor() {
		for (int i = 0; i < 6; i++) {
			final int index = i;
			//执行线程任务
			fixedExecutor.execute(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " index:" + index);
            });
		}
		fixedExecutor.shutdown();//关闭线程池
	}
	
}