package vip.xjdai.list;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.validation.annotation.Validated;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListDemo {

    @Test
    public void list() throws Exception {
        List<Integer> list = Lists.newLinkedList();
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
}
