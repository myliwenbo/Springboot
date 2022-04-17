package vip.xjdai.qinleitest.model;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlRootElement(name = "goods")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlSeeAlso({QXItemRootReuqestBody.QXItemReuqestBody.class})
public class QXItemRootReuqestBody<T> {

    private T item;

    @Data
    @XmlRootElement(name = "item")
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType
    @XmlSeeAlso({QXRequestBody.class})
    public static class QXItemReuqestBody {

        private String matnrname;
        private String matnr;
        private String brandname;
        private String brand;
        private String ZZCJNO;
    }
}