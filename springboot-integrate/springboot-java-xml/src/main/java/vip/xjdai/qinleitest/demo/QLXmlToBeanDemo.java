package vip.xjdai.qinleitest.demo;

import vip.xjdai.qinleitest.model.QXBaseRequest;
import vip.xjdai.qinleitest.model.QXRequestBody;
import vip.xjdai.xmltobean.demo1.JaxbUtil;

public class QLXmlToBeanDemo {

    public static void main(String[] args) {

    }

    public static QXBaseRequest<QXRequestBody> xmlToBean() {

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<Sales>\n" +
                "    <item>\n" +
                "        <summoney />\n" +
                "        <KUNWENAME />\n" +
                "        <PLTYP />\n" +
                "        <city>南京市</city>\n" +
                "        <MATNAME />\n" +
                "        <WERKS>D04001</WERKS>\n" +
                "        <SPADDRESS>江苏南京市鼓楼区鼓楼区江苏省南京市鼓楼区大桥南路9号RELX  悦刻电子烟</SPADDRESS>\n" +
                "        <DJNO>00878865563</DJNO>\n" +
                "        <salestime>20220123 152246</salestime>\n" +
                "        <TELE>18751980725</TELE>\n" +
                "        <Province>江苏</Province>\n" +
                "        <ZZCJNO>6971808581999</ZZCJNO>\n" +
                "        <imeis />\n" +
                "        <kunnr>10101100010003</kunnr>\n" +
                "        <PTEXT />\n" +
                "        <kunnrname>测试代理商2（切勿发货）</kunnrname>\n" +
                "        <WERKNAME>深圳市一号机科技有限公司</WERKNAME>\n" +
                "        <SPPERSON>白皙</SPPERSON>\n" +
                "        <imei>339159396709</imei>\n" +
                "        <KUNWE />\n" +
                "        <MATNR />\n" +
                "    </item>\n" +
                "</Sales>";
        QXBaseRequest<QXRequestBody> res = new QXBaseRequest<>();
        QXBaseRequest<QXRequestBody> helloRes = JaxbUtil.converyToJavaBean(xml, res.getClass());
        return helloRes;

    }
}