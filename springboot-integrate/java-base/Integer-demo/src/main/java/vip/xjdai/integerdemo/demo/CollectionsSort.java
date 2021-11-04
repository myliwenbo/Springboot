package vip.xjdai.integerdemo.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsSort {
    public CollectionsSort() {
    }

    public static void main(String[] args) {
        List<String> list1 = new ArrayList();
        list1.add("A");
        list1.add("B");
        List<String> list2 = new ArrayList();
        list2.add("B");
        list2.add("C");
        list1.addAll(list2);
        System.out.println(list1);
        ArrayList<Integer> arrayList = new ArrayList();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);
        System.out.println("原始的数组：" + arrayList);
        Collections.reverse(arrayList);
        System.out.println("反转后数据：" + arrayList);
        Collections.sort(arrayList, (o1, o2) -> {
            if (o1 > o2) {
                return 1;
            } else {
                return o1 == o2 ? 0 : -1;
            }
        });
        System.out.println("排序后数据：" + arrayList);
        Collections.sort(arrayList);
        System.out.println("自然排序结果：" + arrayList);
        Collections.shuffle(arrayList);
        System.out.println("随机排序：" + arrayList);
        Collections.sort(arrayList, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("定制排序后：" + arrayList);
    }
}