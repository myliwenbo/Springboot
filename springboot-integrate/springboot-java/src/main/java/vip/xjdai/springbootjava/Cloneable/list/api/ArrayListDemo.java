package vip.xjdai.springbootjava.Cloneable.list.api;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ArrayListDemo {

    @Test
    public void list() throws Exception {
        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            //如果添加的话则会报错
            list.add(111);
        }

    }

    /**
     * 利用迭代器的子接口特有的方法 add 即可处理
     *
     * @throws Exception
     */
    @Test
    public void list1() throws Exception {
        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        ListIterator<Integer> lit = list.listIterator();
        while (lit.hasNext()) {
            if (lit.next() == 50) {
                lit.remove();
                lit.add(123); //List独有的方法
            }
            System.out.println(lit.next());
        }
        System.out.println(list.toString());
    }


    @Test
    public void listAdd() throws Exception {
        ArrayList<Integer> list = Lists.newArrayList(5);
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.add(5, 30);
        System.out.println(list.toString());
        list.remove(2);
        System.out.println(list.toString());
        list.add(5, null);
        System.out.println(list.toString());
        List<Integer> integers = Collections.synchronizedList(list);
    }

    @Test
    public void listAddCapacity() throws Exception {
        System.out.println(Integer.toBinaryString(15));
        System.out.println(Integer.valueOf("0111", 2).toString());

    }

}
