package vip.xjdai.qinleitest.model;


import lombok.Data;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * 请求擎雷的模型.. 字段没注释
 */
@Data
@XmlRootElement(name = "Sales")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlSeeAlso({QXRequestBody.class})
public class QXBaseRequest<T> implements Serializable {
    @XmlAnyElement(lax = true)
    private T item;

}
