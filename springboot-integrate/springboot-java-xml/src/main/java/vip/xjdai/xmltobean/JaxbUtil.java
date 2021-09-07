package vip.xjdai.xmltobean;

import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class JaxbUtil {//工具类

    /**
     * xml转换成JavaBean 
     * @param xml
     * @param c
     * @return
     * @throws JAXBException 
     */
    public static <T> T converyToJavaBean(String xml, Class<T> c) {
        try {
            JAXBContext  context      = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            @SuppressWarnings("unchecked")
            T t = (T) unmarshaller.unmarshal(new StringReader (xml));
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
