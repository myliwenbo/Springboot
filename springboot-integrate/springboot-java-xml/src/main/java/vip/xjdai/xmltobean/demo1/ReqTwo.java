package vip.xjdai.xmltobean.demo1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

// *) 具体的实体请求
@Data
@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
public class ReqTwo {

    private String j;
    private String k;

}
