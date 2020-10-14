package vip.xjdai.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.demo.StrongReferenceDemo;

import java.lang.ref.SoftReference;
import java.util.Objects;

@RestController
@RequestMapping
public class ReferenceController {

    private StrongReferenceDemo StrongReferenceDemo;

    //当这个方法执行完毕后，栈中的object它们指向的对象都会被JVM回收。
    //因为引用是在栈中，当弹栈后就没有 引用指向 这个对象了
    //当内存不够的时候就回去回收这个对象
    @RequestMapping("strongReference1")
    public void strongReference1() {
        for (int i = 0; i < 1000; i++) {
            //强引用是指创建一个对象并它赋值给一个引用，引用是存在JVM中的栈中的
            StrongReferenceDemo object = new StrongReferenceDemo(i);
            if (Objects.equals(i, 500)) {
                //将引用指向 500这个对象
                StrongReferenceDemo = object;
            }
        }
        System.out.println("方法执行完毕");
        //可以看到的时候当方法执行完毕后，1000个对象就会被回收
        //但是如果大于内存的话，java.lang.OutOfMemoryError: GC overhead limit exceeded
    }

    //当这个方法执行完毕后，栈中的object它们指向的对象都会被JVM回收。
    //因为引用是在栈中，当弹栈后就没有 引用指向 这个对象了
    //当内存不够的时候就回去回收这个对象，但是如果大于内存的话，java.lang.OutOfMemoryError: GC overhead limit exceeded
    @RequestMapping("strongReference2")
    public void strongReference2() {
        //可以看到的时候当方法执行的过程中，还没执行完毕，就会抛出异常
        for (int i = 0; i < 100000; i++) {
            //强引用是指创建一个对象并它赋值给一个引用，引用是存在JVM中的栈中的
            StrongReferenceDemo object = new StrongReferenceDemo(i);
        }
        System.out.println("方法执行完毕");
    }

    //如果一个对象具有软引用，内存空间足够，垃圾回收器就不会回收它；
    //如果内存空间不足了，就会回收这些对象的内存。
    @RequestMapping("softReference1")
    public void softReference() {
        //可以看到的时候当方法执行的过程中，还没执行完毕，就会抛出异常
        for (int i = 0; i < 100000; i++) {
            //强引用是指创建一个对象并它赋值给一个引用，引用是存在JVM中的栈中的
            SoftReference<StrongReferenceDemo> aSoftRef = new SoftReference<>(new StrongReferenceDemo(i));
            Object o = aSoftRef.get();
            System.out.println(o);
        }
        System.out.println("方法执行完毕");
    }


}
