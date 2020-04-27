package cn.lwb.xml.jaxb;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

public class Snippet {

    public static <E> E XmlToBeanEncoding(String xml, Class<?> c,
                                          String encoding) throws JAXBException,
                                                           UnsupportedEncodingException {
        JAXBContext context = JAXBContext.newInstance(c);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        @SuppressWarnings("unchecked")
        E e = (E) unmarshaller
            .unmarshal(new ByteArrayInputStream(xml.getBytes(encoding)));

        return e;
    }

    public static <T> String BeanToXmlEncoding(T obj,
                                               String encoding) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = jc.createMarshaller();
        // 乱码转换
        marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
        // 格式化生成的xml串
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        // 是否省略XML头申明信息
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Result result = new StreamResult(out);
        marshaller.marshal(obj, result);
        // 转码
        byte[] bystr = out.toByteArray();
        String str = "";
        try {
            str = new String(bystr, encoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

}