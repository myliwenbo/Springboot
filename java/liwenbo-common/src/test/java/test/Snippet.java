/**
 * 
 */
package test;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

/**
 * @author lwb
 *
 */
public class Snippet {

    public static void main(String[] args) throws Exception
    {
        //初始化cat  
        List<Ball> balls = new ArrayList<Ball>();
        balls.add(new Ball("red"));
        balls.add(new Ball("red1"));
        balls.add(new Ball("red2"));
        balls.add(new Ball("red3"));
        balls.add(new Ball("red4"));
        balls.add(new Ball("red5"));
        Cat cat = new Cat("馄饨", 1, balls);
        //初始化结束  
        FileOutputStream fout = new FileOutputStream("cat.xml");
        XStream xs = new XStream();
        xs.toXML(cat, fout);
    }
}
