package vip.xjdai.springbootjaxb.xmltojava;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class AnJiSanYuanCommonBean {
    //操作员代码
    private String CAOZUOYDM = "LINGMAO";
    //操作姓名
    private String CAOZUOYXM = "灵猫";
    //操作日期
    private String CAOZUORQ = new Date().toString();

    private String MessageId = "sadad";

    //nillable：可以指定元素的文本值是否可以为空
    //required：属性可以指定该元素是否必须出现
    @XmlElement(defaultValue = " ", required = true)
    private String MACDZ;

    @XmlElement(defaultValue = " ", required = true)
    private String KEY;

    @XmlElement(defaultValue = " ", required = true)
    private String SIGN;


}
