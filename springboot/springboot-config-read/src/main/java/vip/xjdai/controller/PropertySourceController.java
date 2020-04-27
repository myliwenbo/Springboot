package vip.xjdai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.config.ConfigPropertySource;
import vip.xjdai.config.ConfigurationPropertiesBean;
import vip.xjdai.config.ConfigurationPropertiesDemo;
import vip.xjdai.config.ContigValue;

@RestController
@RequestMapping("propertySource")
public class PropertySourceController
{
    @Autowired
    private ConfigurationPropertiesDemo  configurationPropertiesDemo;
    @Autowired
    private ConfigurationPropertiesBean  configurationPropertiesBean;
    @Autowired
    private ContigValue contigValue;
    @Autowired
    private ConfigPropertySource configPropertySource;

    @RequestMapping("getConfigurationPropertiesDemo")
    public Object getPropertySource()
    {
        return configurationPropertiesDemo.druidDataSource();
    }

    @RequestMapping("geTconfigurationPropertiesBean")
    public Object geTconfigurationPropertiesBean()
    {
        return configurationPropertiesBean.toString();
    }

    @RequestMapping("geContigValue")
    public Object geContigValue()
    {
        return contigValue.getDriverClassName();
    }

    @RequestMapping("configPropertySource")
    public Object getConfigPropertySource()
    {
        return configPropertySource.getName();
    }

}
