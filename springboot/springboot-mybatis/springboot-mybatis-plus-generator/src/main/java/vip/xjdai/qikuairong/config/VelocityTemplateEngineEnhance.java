package vip.xjdai.qikuairong.config;

import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.Map;

public abstract class VelocityTemplateEngineEnhance extends VelocityTemplateEngine {

    private Map<String, Object> objectMap;

    @Override
    public VelocityTemplateEngine init(ConfigBuilder configBuilder) {
        super.init(configBuilder);
        return this;
    }

    public void writer(Map<String, Object> objectMap, String templatePath, String outputFile) throws Exception {
        //将objectMap开放出去
        this.objectMap = objectMap;
        //这里调用增强方法
        enhanceMap(this.objectMap);
        //增强该方法
        super.writer(objectMap, templatePath, outputFile);

    }

    public Map<String, Object> getObjectMap() {
        return objectMap;
    }


    /**
     * 添加
     */
    public abstract void enhanceMap(Map<String, Object> objectMap);


}
