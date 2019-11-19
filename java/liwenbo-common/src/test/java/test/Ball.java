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
//颜色  
public class Ball {
    //颜色
    private String color;

    Ball(String color) {
        this.color = color;
    }
}
