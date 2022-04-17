package vip.xjdai.springbootjaxb.泛型.model;
 
import lombok.Data;
 
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
/**
 * @ClassNAME AgeAndSex
 * @Description 年龄与性别对象
 * @Author XiongMao
 * @Date 2019-9-8
 */
@Data
@XmlRootElement(name="AGEANDSEX")
@XmlAccessorType(XmlAccessType.FIELD)
public class AgeAndSex {
    @XmlElement(name="AGE")
    private String age;
    @XmlElement(name="SEX")
    private String sex;
}