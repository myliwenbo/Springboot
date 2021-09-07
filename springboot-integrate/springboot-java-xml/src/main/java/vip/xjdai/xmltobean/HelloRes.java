package vip.xjdai.xmltobean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement (name = "req")
@XmlAccessorType(XmlAccessType.FIELD)
public class HelloRes<T> {

    private String header;

    private T      reqTwo;
}
