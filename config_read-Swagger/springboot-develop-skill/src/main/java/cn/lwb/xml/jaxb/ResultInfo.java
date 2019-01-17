package cn.lwb.xml.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@Data
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "resultInfo")
public class ResultInfo {
    private String resultStatus;
    private String resultCode;
    private String resultMsg;

}
