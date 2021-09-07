package vip.xjdai.springbootasync;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
public class BeasService {

    @Lazy(value = true)
    @Autowired
    private BeasService beasService;


    public void superTest() throws Exception {

        this.beasService.superTest2();
    }

    @Async
    public void superTest2() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("异步方法线程：" + Thread.currentThread());
    }

}
