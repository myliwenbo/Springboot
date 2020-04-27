package cn.lwb.xml.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "document")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseDocumentBO<T> {

    @XmlElement(name = "response")
    private ResponseBO<T> responseBO;

    @XmlElement(name = "signature")
    private String        signature;

    public ResponseBO<T> getResponseBO() {
        return responseBO;
    }

    public void setResponseBO(ResponseBO<T> responseBO) {
        this.responseBO = responseBO;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

}
