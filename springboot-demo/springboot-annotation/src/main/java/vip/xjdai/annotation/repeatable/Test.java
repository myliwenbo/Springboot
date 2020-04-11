/**
 *
 */
package vip.xjdai.annotation.repeatable;

import java.lang.annotation.Annotation;

/**
 * @author lwb
 *
 */
public class Test {

    public static void main(String[] args) {
        Annotation[] annotations = Man.class.getAnnotations();
        System.out.println(annotations.length);
        Persons p1 = (Persons) annotations[0];
        for (Person t : p1.value()) {
            System.out.println(t.role());
        }
    }
}
