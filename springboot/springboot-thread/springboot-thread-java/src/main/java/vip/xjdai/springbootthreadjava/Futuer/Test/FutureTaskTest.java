package vip.xjdai.springbootthreadjava.Futuer.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new CallableSub());
        //主线程往下走
        System.out.println("xxx");
        System.out.println("继续往下走");
        System.out.println(futureTask.get());
        System.out.println("继续往下走");
    }
}

class CallableSub implements Callable<String> {


    @Override
    public String call() throws Exception {
        Thread.sleep(5000);
        return "张三";
    }
}
