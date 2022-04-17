package vip.xjdai.qinleitest.demo;

import vip.xjdai.javatoxml.demo1.XMLUtils;
import vip.xjdai.qinleitest.model.QXItemRootReuqestBody;

public class BeanToXmlDemo2 {

    public static void main(String[] args) {
        QXItemRootReuqestBody<QXItemRootReuqestBody.QXItemReuqestBody> qxItemReuqestBodyQXItemRootReuqestBody = QLXmlToBeanDemo2.xmlToBean();
        XMLUtils.beanToXml(qxItemReuqestBodyQXItemRootReuqestBody);
    }
}
