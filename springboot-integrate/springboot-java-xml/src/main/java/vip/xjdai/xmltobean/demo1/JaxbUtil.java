package vip.xjdai.xmltobean.demo1;

import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class JaxbUtil {//工具类

    /**
     * xml转换成JavaBean
     *
     * @param xml
     * @param c
     * @return
     * @throws JAXBException
     */
    public static <T> T converyToJavaBean(String xml, Class<T> cazz) {
        try {
            JAXBContext context = JAXBContext.newInstance(cazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
//            @SuppressWarnings("unchecked")
            return (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
