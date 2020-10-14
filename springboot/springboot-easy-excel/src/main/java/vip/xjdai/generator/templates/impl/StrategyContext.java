package vip.xjdai.generator.templates.impl;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.google.common.collect.Lists;
import vip.xjdai.generator.templates.Templates;

import java.util.HashMap;
import java.util.List;

;

public class StrategyContext {

    private List<FileOutConfig> focList;

    public void contextMethod(Templates templates) {
        FileOutConfig fileOutConfig = templates.contextMethod();
        focList.add(fileOutConfig);
    }

    public void getInjectionConfig(AutoGenerator mpg) {
        // 注入自定义配置，可以在 VM 中使用 cfg.abc
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                this.setMap(new HashMap<>());
            }
        };
        injectionConfig.setFileOutConfigList(this.focList);
        mpg.setCfg(injectionConfig);
    }

    public static class StrategyContextOne {
        static StrategyContext instance = new StrategyContext();
    }

    public static StrategyContext getTemplatesList() {
        StrategyContext strategyContext = StrategyContextOne.instance;
        strategyContext.focList = Lists.newArrayList();
        return strategyContext;
    }

    public List<FileOutConfig> getFocList() {
        return focList;
    }
}