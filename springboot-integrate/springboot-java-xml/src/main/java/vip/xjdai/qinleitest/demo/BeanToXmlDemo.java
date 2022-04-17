package vip.xjdai.qinleitest.demo;

import vip.xjdai.javatoxml.demo1.XMLUtils;
import vip.xjdai.qinleitest.model.QXBaseRequest;
import vip.xjdai.qinleitest.model.QXRequestBody;

public class BeanToXmlDemo {

    public static void main(String[] args) {
        QXBaseRequest<QXRequestBody> qxRequestBodyQXBaseRequest = QLXmlToBeanDemo.xmlToBean();
        XMLUtils.beanToXml(qxRequestBodyQXBaseRequest);
    }
}
