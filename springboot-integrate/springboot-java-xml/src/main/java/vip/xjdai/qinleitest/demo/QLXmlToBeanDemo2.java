package vip.xjdai.qinleitest.demo;

import vip.xjdai.qinleitest.model.QXItemRootReuqestBody;
import vip.xjdai.xmltobean.demo1.JaxbUtil;

public class QLXmlToBeanDemo2 {

    public static void main(String[] args) {

    }

    public static QXItemRootReuqestBody<QXItemRootReuqestBody.QXItemReuqestBody> xmlToBean() {

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<goods>\n" +
                "    <item>\n" +
                "        <matnrname />\n" +
                "        <matnr />\n" +
                "        <brandname>RELX悦刻</brandname>\n" +
                "        <brand>354</brand>\n" +
                "        <ZZCJNO>6971808581999</ZZCJNO>\n" +
                "    </item>\n" +
                "</goods>";
        QXItemRootReuqestBody<QXItemRootReuqestBody.QXItemReuqestBody> res = new QXItemRootReuqestBody<>();
        QXItemRootReuqestBody<QXItemRootReuqestBody.QXItemReuqestBody> qxItemRootReuqestBody = JaxbUtil.converyToJavaBean(xml, res.getClass());
        return qxItemRootReuqestBody;

    }
}