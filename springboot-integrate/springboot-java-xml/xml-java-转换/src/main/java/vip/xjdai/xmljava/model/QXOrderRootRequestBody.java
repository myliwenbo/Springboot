package vip.xjdai.xmljava.model;

import com.google.common.collect.Lists;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * 请求擎雷的模型.. 字段没注释
 */
@Data
@XmlRootElement(name = "Sales")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class QXOrderRootRequestBody {
    public static final String MODEL_MODEL = "qts.tracecode.QXOrderRootRequestBody";

    private List<QXRequestBody> item;

    /**
     * 将方法放进来.
     *
     * @return
     */
    public static QXOrderRootRequestBody createQXRequestBodyList() {
        QXOrderRootRequestBody qxOrderRootRequestBody = new QXOrderRootRequestBody();
        ArrayList<QXRequestBody> qxRequestBodies = Lists.newArrayList();
        qxOrderRootRequestBody.setItem(qxRequestBodies);
        return qxOrderRootRequestBody;
    }


    @Data
    @XmlRootElement(name = "item")
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(propOrder = {"DJNO", "MATNR", "MATNAME", "summoney", "PLTYP"
            , "PTEXT", "ZZCJNO", "WERKS", "WERKNAME", "kunnr", "kunnrname"
            , "KUNWE", "KUNWENAME", "SPADDRESS", "SPPERSON", "TELE", "Province", "city", "salestime", "imeis", "imei"
    })
    public static class QXRequestBody {

        /**
         * 外部订单编号
         */
        private String DJNO;

        /**
         * 10码
         */
        private String MATNR;

        /**
         * 产品名称
         */
        private String MATNAME;

        private String summoney;

        private String PLTYP;

        private String PTEXT;

        private String ZZCJNO;

        private String WERKS;

        private String WERKNAME;

        private String kunnr;

        private String kunnrname;

        private String KUNWE;

        private String KUNWENAME;

        private String SPADDRESS;

        private String SPPERSON;

        private String TELE;

        private String Province;

        private String city;

        private String salestime;

        private String imeis;

        private String imei;
    }


}