package vip.xjdai.springbootjava.Cloneable.list.ArrayList;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ArrayListTest {

    @Test
    public void add() throws Exception {
        ArrayList<Object> objects = Lists.newArrayList();
        objects.add("1");
    }

    @Test
    public void 扩容() throws Exception {
        System.out.println(10 >> 1);
    }
    @Test
    public void delete() throws Exception {
        ArrayList<Object> objects = Lists.newArrayList();
        for (int i = 0; i < 50; i++) {
            objects.add(i);
        }
        objects.remove(10);
        System.out.println(objects);
    }
}
