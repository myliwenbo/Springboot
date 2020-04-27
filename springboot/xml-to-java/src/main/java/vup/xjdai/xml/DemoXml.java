package vup.xjdai.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class DemoXml extends AnJiSanYuanResponse
{
    private String GUAHAOFS;
    private String GUAHAOBC;
    private String GUAHAOLB;
    private String KSXSLX;
    private String RIQI;

    public String getGUAHAOFS()
    {
        return GUAHAOFS;
    }

    public void setGUAHAOFS(String GUAHAOFS)
    {
        this.GUAHAOFS = GUAHAOFS;
    }

    public String getGUAHAOBC()
    {
        return GUAHAOBC;
    }

    public void setGUAHAOBC(String GUAHAOBC)
    {
        this.GUAHAOBC = GUAHAOBC;
    }

    public String getGUAHAOLB()
    {
        return GUAHAOLB;
    }

    public void setGUAHAOLB(String GUAHAOLB)
    {
        this.GUAHAOLB = GUAHAOLB;
    }

    public String getKSXSLX()
    {
        return KSXSLX;
    }

    public void setKSXSLX(String KSXSLX)
    {
        this.KSXSLX = KSXSLX;
    }

    public String getRIQI()
    {
        return RIQI;
    }

    public void setRIQI(String RIQI)
    {
        this.RIQI = RIQI;
    }
}
