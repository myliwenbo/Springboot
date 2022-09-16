package vip.xjdai.springbootjaxb.demo1;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 灵猫文档统一请求第三方
 */

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@Data
public class LingMaoRequest {
    private LingMaoHead head;
    private LingMaoOutpatientDepartments boby;

}
