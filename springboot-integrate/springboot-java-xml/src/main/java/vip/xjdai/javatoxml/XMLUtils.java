package vip.xjdai.javatoxml;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLUtils {

    public static <E> void beanToXml(Req<E> rqu)
    {
        try {
            StringWriter sw = new StringWriter();
            JAXBContext context = JAXBContext.newInstance(rqu.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(rqu, sw);
            System.out.println(sw.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static <E> void xmlToBean(Req<E> rqu, String text)
    {
        try {
            JAXBContext jc = JAXBContext.newInstance(rqu.getClass());
            Unmarshaller unmar = jc.createUnmarshaller();
            unmar.unmarshal(new StringReader(text));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
