package vip.xjdai.springbootjaxb.demo3;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class DemoXml extends AnJiSanYuanResponse {
    private String GUAHAOFS;
    private String GUAHAOBC;
    private String GUAHAOLB;
    private String KSXSLX;
    private String RIQI;

}
