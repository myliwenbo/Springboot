package vup.xjdai.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

public class XmlToBean
{

    public static void main(String[] args)
    {
        DemoXml anJiSanYuanResponse = AnJiSanYuanResponse.CreateAnJiSanYuanResponse(new DemoXml(), "123321");
        beanToXml(anJiSanYuanResponse);
    }

    public static < T > void beanToXml(T rqu)
    {
        try {
            StringWriter sw         = new StringWriter();
            JAXBContext  context    = JAXBContext.newInstance(rqu.getClass());
            Marshaller   marshaller = context.createMarshaller(); //获取初始化的 Marshaller
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);   //格式化输出
            marshaller.setListener(new MarshallerListener()); //设置监听器
            marshaller.marshal(rqu, sw);
            String result = sw.toString();
            result = result.replace("standalone=\"yes\"", "");//去掉standalone="yes"
            System.out.println(result);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
