package vip.xjdai.springbootjaxb.javatoxml;

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
public class LingMaoRequest {
    private LingMaoHead head;

    private Object boby;

    public LingMaoHead getHead() {
        return head;
    }

    public void setHead(LingMaoHead head) {
        this.head = head;
    }

    public Object getBoby() {
        return boby;
    }

    public void setBoby(Object boby) {
        this.boby = boby;
    }
}
