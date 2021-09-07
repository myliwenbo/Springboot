package cn.lwb.set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsSort {

    public static void main(String[] args)
    {

        List<String> list1 = new ArrayList<String>();
        list1.add("A");
        list1.add("B");
        List<String> list2 = new ArrayList<String>();
        list2.add("B");
        list2.add("C");
        list1.addAll(list2);
        System.out.println(list1);

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
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
        arrayList.sort((o1, o2) -> {
            //按照学生的年龄进行升序排列
            if (o1 > o2) {
                return 1;
            }
            if (o1.intValue() == o2.intValue()) {
                return 0;
            }
            return -1;
        });
        System.out.println("排序后数据：" + arrayList);
        Collections.sort(arrayList);
        System.out.println("自然排序结果：" + arrayList);
        Collections.shuffle(arrayList);
        System.out.println("随机排序：" + arrayList);
        // 定制排序的用法
        arrayList.sort(Comparator.reverseOrder());
        System.out.println("定制排序后：" + arrayList);
    }

}