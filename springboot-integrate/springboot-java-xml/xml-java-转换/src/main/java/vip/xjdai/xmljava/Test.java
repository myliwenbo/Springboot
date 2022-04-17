package vip.xjdai.xmljava;

import jdk.nashorn.internal.objects.annotations.Function;
import org.apache.commons.lang3.StringUtils;
import vip.xjdai.xmljava.model.QXOrderRootRequestBody;
import vip.xjdai.xmljava.utils.XMLUtils;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        createXmlToUpload();
    }

    public static void createXmlToUpload() {
        QXOrderRootRequestBody qxRequestBodyList = QXOrderRootRequestBody.createQXRequestBodyList();
        List<QXOrderRootRequestBody.QXRequestBody> qxRequestBodies = qxRequestBodyList.getItem();

        // 将一号机转换成擎雷的
        QXOrderRootRequestBody.QXRequestBody qxRequestBody = toQXRequestBody();
        qxRequestBodies.add(qxRequestBody);
        String salesXMLString = XMLUtils.beanToXml(qxRequestBodyList);
    }

    private static QXOrderRootRequestBody.QXRequestBody toQXRequestBody() {
        QXOrderRootRequestBody.QXRequestBody qxRequestBody = new QXOrderRootRequestBody.QXRequestBody();
        qxRequestBody.setDJNO("");
        qxRequestBody.setMATNR("");
        qxRequestBody.setMATNAME("");
        qxRequestBody.setSummoney("");
        qxRequestBody.setPLTYP("");
        qxRequestBody.setPTEXT("");
        qxRequestBody.setZZCJNO("");
        qxRequestBody.setWERKS("");
        qxRequestBody.setWERKNAME("");
        qxRequestBody.setKunnr("");
        qxRequestBody.setKunnrname("");
        qxRequestBody.setKUNWE("");
        qxRequestBody.setKUNWENAME("");
        qxRequestBody.setSPADDRESS("");
        qxRequestBody.setSPPERSON("");
        qxRequestBody.setTELE("");
        qxRequestBody.setProvince("");
        qxRequestBody.setCity("");
        qxRequestBody.setSalestime("");
        qxRequestBody.setImeis("");
        qxRequestBody.setImei("");
        return qxRequestBody;
    }
}
