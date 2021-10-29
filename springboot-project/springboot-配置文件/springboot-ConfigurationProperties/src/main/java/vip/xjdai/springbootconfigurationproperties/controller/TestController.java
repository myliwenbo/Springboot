package vip.xjdai.springbootconfigurationproperties.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.springbootconfigurationproperties.config.ConfigurationPropertiesBean;
import vip.xjdai.springbootconfigurationproperties.model.AttributeReadModel;

@RestController
@RequestMapping("TestController")
public class TestController {

    @Autowired
    private ConfigurationPropertiesBean configurationPropertiesBean;
    @Autowired
    private AttributeReadModel attributeReadModel;

    @RequestMapping("test")
    public ConfigurationPropertiesBean configurationPropertiesBean() {
        return configurationPropertiesBean;
    }

    @RequestMapping("tes2")
    public AttributeReadModel attributeReadModel() {
        return attributeReadModel;
    }
}
