package cn.lwb.xml.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseBO<T> {

    @XmlElement(name = "head")
    private ResponseHeadBO head;

    @XmlElement(name = "body")
    private T              body;

    public ResponseHeadBO getHead() {
        return head;
    }

    public void setHead(ResponseHeadBO head) {
        this.head = head;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

}
