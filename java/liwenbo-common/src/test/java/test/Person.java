/**
 * 
 */
package test;

import lombok.Data;

/**
 * @author lwb
 *
 */
@Data
public class Person {

    private String x;
    private String m;

    public Person(String x, String m) {
        super();
        this.x = x;
        this.m = m;
    }

}
