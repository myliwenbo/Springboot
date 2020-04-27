package vip.xjdai.qikuairong.config;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

import java.util.Map;

/**
 * 配置包相关信息
 */
public class TemplateConfigEnhance {

    private AutoGenerator mpg;


    public TemplateConfigEnhance(AutoGenerator mpg) {
        this.mpg = mpg;
        createVelocityTemplateEngine();
    }

    private void createVelocityTemplateEngine() {
        TemplateConfigEnhance thiz = this;
        VelocityTemplateEngineEnhance velocityTemplateEngineEnhance = new VelocityTemplateEngineEnhance() {
            @Override
            public void enhanceMap(Map<String, Object> objectMap) {
                thiz.add(objectMap);
            }
        };
        mpg.setTemplateEngine(velocityTemplateEngineEnhance);//定义模板的自定义属性
    }

    /**
     * 需要注意的是这个会改变原有的标签，不要瞎几把改!
     *
     * @param objectMap
     */
    @SuppressWarnings("unchecked" )
    public void add(Map<String, Object> objectMap) {
        TableInfoConfigEnhance table = new TableInfoConfigEnhance((TableInfo) objectMap.get("table" ));
        objectMap.put("package", new PackageConfigEnhance((Map<String, String>) objectMap.get("package" )).getPackageInfo()); //替换package信息
        objectMap.put("table", table); //替换package信息
//        objectMap.put("superClass", new SuperConfigEnhance()); //替换package信息


    }
}
