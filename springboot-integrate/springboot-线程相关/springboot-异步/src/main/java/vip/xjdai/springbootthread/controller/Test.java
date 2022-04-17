package vip.xjdai.springbootthread.controller;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.springbootthread.TestService;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("Test")
public class Test {

    @Autowired
    private TestService testService;

    @RequestMapping("test")
    public ArrayList<String> test() throws ExecutionException, InterruptedException {
        ArrayList<Future<String>> futureArrayList = Lists.newArrayList();
        ArrayList<String> newArrayList = Lists.newArrayList();
        long l = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Future<String> stringFuture = testService.asynchronousMethod();
            futureArrayList.add(stringFuture);
        }
        futureArrayList.forEach(item -> {
            try {
                newArrayList.add(item.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
        return newArrayList;
    }


}
