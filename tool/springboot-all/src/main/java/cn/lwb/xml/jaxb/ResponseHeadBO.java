package cn.lwb.xml.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@Data
@XmlType
@XmlRootElement(name = "head")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseHeadBO {

    private String appid;
    private String function;
    private String respTime;
    private String respTimeZone;
    private String reqMsgId;
}
