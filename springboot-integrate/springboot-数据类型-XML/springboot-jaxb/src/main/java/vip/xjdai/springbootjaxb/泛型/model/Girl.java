package vip.xjdai.springbootjaxb.泛型.model;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @ClassNAME girl
 * @Description 女孩儿对象
 * @Author XiongMao
 * @Date 2019-9-8
 */
@Data
@XmlRootElement(name = "GIRL")
@XmlAccessorType(XmlAccessType.FIELD)
public class Girl<T> {
    @XmlElement(name = "NAME")
    private String name;
    /**
     * XmlAnyElement 这个注解可以去调生成的xml中带的xsi:type等信息，使用这个注解就不能使用 @XmlElement，
     * 需要在泛型对应的实体上增加 @XmlRootElement 注解
     * XmlElementWrapper 这个注解可以在集合外层包装一个节点
     */
    @XmlAnyElement(lax = true)
    private T ageAndSex;
}