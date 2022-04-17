package vip.xjdai.springbootthread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class TestService {

    @Async("taskExecutor")
    public Future<String> asynchronousMethod() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>(Thread.currentThread().getName());
    }
}
