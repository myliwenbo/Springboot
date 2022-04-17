package vip.xjdai.springbootjaxb.泛型;

import vip.xjdai.springbootjaxb.泛型.model.AgeAndSex;
import vip.xjdai.springbootjaxb.泛型.model.Girl;
import vip.xjdai.springbootjaxb.泛型.tuils.XmlUtil;

import javax.xml.bind.JAXBException;

public class SpringbootJaxbApplication {

    public static void main(String[] args) {

        Girl girl = new Girl();
        girl.setName("小红");
        AgeAndSex ageAndSex = new AgeAndSex();
        ageAndSex.setAge("18");
        ageAndSex.setSex("女");
        girl.setAgeAndSex(ageAndSex);
        System.out.println("组装完成的对象值为：" + girl);
        //方法调用并输出
        Girl newGirl = new Girl();
        String xml;
        try {
            xml = XmlUtil.beanToXml(girl, AgeAndSex.class);
            System.out.println("bean转成xml格式为：" + xml);
            newGirl = XmlUtil.xmlToBean(xml, newGirl, AgeAndSex.class);
            System.out.println("xml转成bean格式为：" + newGirl);
        } catch (JAXBException e) {
            e.printStackTrace();

        }
    }
}
