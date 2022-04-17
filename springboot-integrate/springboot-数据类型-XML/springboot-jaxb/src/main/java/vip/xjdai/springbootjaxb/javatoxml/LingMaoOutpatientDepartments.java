package vip.xjdai.springbootjaxb.javatoxml;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class LingMaoOutpatientDepartments {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
