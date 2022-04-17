package vip.xjdai.springbootjaxb.javatoxml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Date;
import java.util.UUID;

public class JavaToXml {

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        LingMaoOutpatientDepartments lingMaoOutpatientDepartments = new LingMaoOutpatientDepartments();
        lingMaoOutpatientDepartments.setName("123");
        try {
            LingMaoRequest lingMaoRequest = new LingMaoRequest();
            lingMaoRequest.setHead(getLingMaoRequest());
            lingMaoRequest.setBoby(lingMaoOutpatientDepartments);
            JAXBContext context = JAXBContext.newInstance(lingMaoRequest.getClass());
            StringWriter writer = new StringWriter();
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mar.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            mar.marshal(lingMaoRequest, writer);
            String result = writer.toString();
            System.out.println(result);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static LingMaoHead getLingMaoRequest() {
        //获取枚举值
        LingMaoHead lingMaoHead = new LingMaoHead();
        lingMaoHead.setRtnCod("200");
        lingMaoHead.setRtnMsg("操作成功");
        lingMaoHead.setVersio("1.0.0");
        lingMaoHead.setSource("LINGMAO");
        lingMaoHead.setDesIfn("五莲县康复医院");
        lingMaoHead.setServCo("123");
        lingMaoHead.setMsgId(UUID.randomUUID().toString().replace("-", ""));
        lingMaoHead.setMsgTim(String.valueOf(new Date().getTime()));
        lingMaoHead.setExtend("");
        return lingMaoHead;
    }

}
