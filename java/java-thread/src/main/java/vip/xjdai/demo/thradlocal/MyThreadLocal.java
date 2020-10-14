package vip.xjdai.demo.thradlocal;

import com.sun.org.apache.bcel.internal.generic.ObjectType;

import java.util.concurrent.ConcurrentHashMap;

public class MyThreadLocal {
    /**
     * 定义
     */
    private ConcurrentHashMap<Long, Object> threadMap;


    public void get() {
        Thread thread = Thread.currentThread();
        threadMap.get(thread.getId());
    }

    public void set(Object value) {
        Thread thread = Thread.currentThread();
        //判断Map存在不存在，不存在去创建，或者直接创建或者使用内部类懒加载
        threadMap.put(thread.getId(), value);
    }

}
