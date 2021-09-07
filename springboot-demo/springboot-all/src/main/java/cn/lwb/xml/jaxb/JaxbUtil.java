package cn.lwb.xml.jaxb;

import java.io.StringReader;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JaxbUtil {//工具类

    /**
     * xml转换成JavaBean 
     * @param <clazz>
     * @param <T>
     * @param xml
     * @param c
     * @return
     * @throws JAXBException 
     */
    @SuppressWarnings("unchecked")
    public static <T> T converyToJavaBean(String xml, Class<T> c) {
        try {
            JAXBContext context = JAXBContext.newInstance(c.getClass());
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T convertToJavaBean(Class<T> clz, String file) {
        return JAXB.unmarshal(file, clz);
    }

}
