package vup.xjdai.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
public class AnJiSanYuanCommonBean
{
    //操作员代码
    private String CAOZUOYDM = "LINGMAO";
    //操作姓名
    private String CAOZUOYXM = "灵猫";
    //操作日期
    private String CAOZUORQ  = new Date().toString();

    private String MessageId = "sadad";

    //nillable：可以指定元素的文本值是否可以为空
    //required：属性可以指定该元素是否必须出现
    @XmlElement(defaultValue = " ", required = true)
    private String MACDZ;

    @XmlElement(defaultValue = " ", required = true)
    private String KEY;

    @XmlElement(defaultValue = " ", required = true)
    private String SIGN;

    public String getCAOZUOYDM()
    {
        return CAOZUOYDM;
    }

    public void setCAOZUOYDM(String CAOZUOYDM)
    {
        this.CAOZUOYDM = CAOZUOYDM;
    }

    public String getCAOZUOYXM()
    {
        return CAOZUOYXM;
    }

    public void setCAOZUOYXM(String CAOZUOYXM)
    {
        this.CAOZUOYXM = CAOZUOYXM;
    }

    public String getCAOZUORQ()
    {
        return CAOZUORQ;
    }

    public void setCAOZUORQ(String CAOZUORQ)
    {
        this.CAOZUORQ = CAOZUORQ;
    }

    public String getMessageId()
    {
        return MessageId;
    }

    public void setMessageId(String messageId)
    {
        MessageId = messageId;
    }

    public String getMACDZ()
    {
        return MACDZ;
    }

    public void setMACDZ(String MACDZ)
    {
        this.MACDZ = MACDZ;
    }

    public String getKEY()
    {
        return KEY;
    }

    public void setKEY(String KEY)
    {
        this.KEY = KEY;
    }

    public String getSIGN()
    {
        return SIGN;
    }

    public void setSIGN(String SIGN)
    {
        this.SIGN = SIGN;
    }
}
