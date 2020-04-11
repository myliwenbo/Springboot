/**
 *
 */
package cn.lwb.map;

import java.util.HashMap;

/**
 * @author lwb
 *
 */
public class Snippet {

    public static void main(String[] args) {
        System.out.println("没put");
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("1", "1");
        System.out.println("put后");
        //        hashMap.put("2", "2");
        //        hashMap.put("3", "2");
        //        hashMap.put("4", "2");
        //        hashMap.put("5", "2");
        //        hashMap.put("6", "2");
        //        hashMap.put("7", "2");
        //        hashMap.put("8", "2");
        //        hashMap.put("9", "2");
        //        hashMap.put("10", "2");
        //        hashMap.put("11", "2");
        hashMap.put("12", "2");
        //        hashMap.put("13", "2");
        //1073741824
        System.out.println(1 << 3);
    }
}
