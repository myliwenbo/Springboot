package vip.xjdai.list;

import com.google.common.collect.Lists;

import java.util.List;

public class Demo {

    private List<Integer> test() {
        return Lists.newArrayList();
    }
}

class DemoSub extends Demo {
    public List<Integer> test() {
        return Lists.newLinkedList();
    }
}