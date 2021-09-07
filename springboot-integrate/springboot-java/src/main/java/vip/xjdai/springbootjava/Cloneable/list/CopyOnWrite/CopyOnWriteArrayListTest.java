package vip.xjdai.springbootjava.Cloneable.list.CopyOnWrite;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<>();
        list.add("xxx");
        list.get(1);
    }
}
