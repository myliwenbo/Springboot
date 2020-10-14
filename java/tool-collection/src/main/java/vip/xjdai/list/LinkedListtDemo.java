package vip.xjdai.list;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LinkedListtDemo {

    @Test
    public void LinkedListtDemo() throws Exception {

        LinkedList<Integer> list=new LinkedList<>();
        list.add(1);
        list.get(0);
        ConcurrentLinkedQueue<Integer> lis2=new ConcurrentLinkedQueue<>();
        lis2.add(1);
        Vector<Integer> list3=new Vector<>();
        list3.add(1);
        list3.add(null);
        list3.add(2);
        System.out.println(list3.toString());


    }
}
