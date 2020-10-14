package vip.xjdai.lambdatest;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * 循序渐进血虚 Limbda 表达式
 */
public class LimbdaTest {


    @Test
    public void limbdat0() throws Exception {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        System.out.println(names.toString());

    }

    /**
     * 去掉了
     *
     * @throws Exception
     */
    @Test
    public void limbdat1() throws Exception {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (String a, String b) -> {
                    return b.compareTo(a);
                }
        );
        System.out.println(names.toString());
    }

    @Test
    public void limbdat2() throws Exception {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (a, b) -> {
                    return b.compareTo(a);
                }
        );
        System.out.println(names.toString());
    }

    @Test
    public void limbdat3() throws Exception {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (a, b) -> {
                    return b.compareTo(a);
                }
        );
        System.out.println(names.toString());
    }

    @Test
    public void limbdat4() throws Exception {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (a, b) -> b.compareTo(a));
        System.out.println(names.toString());
    }

    @Test
    public void limbdat5() throws Exception {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, Comparator.reverseOrder());
        System.out.println(names.toString());
    }

    /**
     * 1.8 自带了 sort排序 直接调用即可
     * @throws Exception
     */
    @Test
    public void limbdat6() throws Exception {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        names.sort(Comparator.reverseOrder());
        System.out.println(names.toString());
    }
}