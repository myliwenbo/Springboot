package vip.xjdai.springbootbasal.set;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.TreeSet;

@Data
public class TreeSetTest{

    private String name;
    private Integer age;

    public TreeSetTest(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        TreeSet<TreeSetTest> treeSet = new TreeSet<>(new Comparator<TreeSetTest>() {
            @Override
            public int compare(TreeSetTest o1, TreeSetTest o2) {
                return 0;
            }
        });
        treeSet.add(new TreeSetTest("小明", 1));
        treeSet.add(new TreeSetTest("小明", 2));
        treeSet.add(new TreeSetTest("小明", 3));
        treeSet.add(new TreeSetTest("小三", 3));
        treeSet.add(new TreeSetTest("小三", 8));
        treeSet.add(new TreeSetTest("王五", 3));
        treeSet.add(new TreeSetTest("王五", 4));
        Comparator<? super TreeSetTest> comparator = treeSet.comparator();

    }

//    @Override
//    public int compareTo(TreeSetTest o) {
//        boolean equals = this.getName().equals(o.getName());
//        if (equals) {
//            return 0;
//        }
//        return 1;
//    }
//    @Override
//    public int compare(TreeSetTest o1, TreeSetTest o2) {
//        return 0;
//    }
}
