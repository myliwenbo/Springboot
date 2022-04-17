package vip.xjdai.xmljava.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class XMLUtils {

    public static <T> String beanToXml(T rqu) {
        try {
            StringWriter sw = new StringWriter();
            JAXBContext context = JAXBContext.newInstance(rqu.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(rqu, sw);
            String result = sw.toString().replace("standalone=\"yes\"", "");//去掉standalone="yes"
            System.out.println(result);
            return result;
        } catch (JAXBException e) {
            e.printStackTrace();
            return "";
        }
    }


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
