package vip.xjdai.springbootasync;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class TestService extends BeasService {


    public void test() throws Exception {
        this.superTest();
        System.out.println(Thread.currentThread()); //当前线程
    }

}
