package vip.xjdai.lambdatest;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class LimbdaTest {


    @Test
    public void limbdatTest0() throws Exception {
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
    public void limbdatTest1() throws Exception {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (String a, String b) -> {
                    return b.compareTo(a);
                }
        );
        System.out.println(names.toString());
    }

    @Test
    public void limbdatTest2() throws Exception {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (String a, String b) -> {
                    return b.compareTo(a);
                }
        );
        System.out.println(names.toString());
    }

    @Test
    public void limbdatTest3() throws Exception {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (a, b) -> {
                    return b.compareTo(a);
                }
        );
        System.out.println(names.toString());
    }

    @Test
    public void limbdatTest4() throws Exception {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (a, b) -> b.compareTo(a));
        System.out.println(names.toString());
    }

    @Test
    public void limbdatTest5() throws Exception {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, Comparator.reverseOrder());
        System.out.println(names.toString());
    }
}