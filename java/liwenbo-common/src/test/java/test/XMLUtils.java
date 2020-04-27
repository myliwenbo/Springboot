/**
 * 
 */
package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.thoughtworks.xstream.XStream;

/**
 * @author lwb
 *
 */
public class XMLUtils {

    public static void main(String[] args) throws FileNotFoundException
    {
        XStream xstream = new XStream();
        xstream.alias("person", Person.class);
        Person joe = new Person("Joe", "Walnes");
        String xml = xstream.toXML(joe);
        System.out.println(xml);
        xstream.toXML(joe, new FileOutputStream(new File("xxx.xml")));

    }
}
