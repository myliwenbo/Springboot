package vip.xjdai.qikuairong.config;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

import java.util.Map;

/**
 * 配置包相关信息
 */
public class TemplateConfigEnhance extends VelocityTemplateEngineEnhance {

    private boolean entityExct;

    /**
     * 是否开启导入导出
     * @param entityExct
     */
    public TemplateConfigEnhance(Boolean entityExct) {
        this.entityExct = entityExct;
    }

    /**
     * 添加
     *
     * @param objectMap
     */
    @Override
    public void enhanceMap(Map<String, Object> objectMap) {
        this.add(objectMap);
    }

    /**
     * 需要注意的是这个会改变原有的标签，不要瞎几把改!
     *
     * @param objectMap
     */
    @SuppressWarnings("unchecked" )
    public void add(Map<String, Object> objectMap) {
        objectMap.put("package", new PackageConfigEnhance((Map<String, String>) objectMap.get("package" )).getPackageInfo()); //替换package信息
        objectMap.put("table", new TableInfoConfigEnhance((TableInfo) objectMap.get("table" ))); //替换package信息
        objectMap.put("entityExct", entityExct);
    }


}
