package vip.xjdai.generator.config;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.google.common.collect.Maps;
;
import lombok.Data;
import lombok.EqualsAndHashCode;
import vip.xjdai.generator.templates.Templates;

import java.util.Map;

/**
 * package配置
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PackageConfigEnhance extends PackageConfig {

    private Map<String, String> packageInfo = Maps.newHashMap();
    private String saveEntity = "";
    private String queryEntity = "";
    private String voEntity = "";
    private String dtoEntity = "";
    private String customizeService = "";
    private String manager = "";

    public PackageConfigEnhance(Map<String, String> packageInfo) {
        this.packageInfo = packageInfo;
        init();
    }


    public Map<String, String> getPackageInfo() {
        packageInfo.put("Entity", joinPackage(this.getParent(), this.getEntity()));
        packageInfo.put("SaveEntity", joinPackage(this.getParent(), this.getSaveEntity()));
        packageInfo.put("QueryEntity", joinPackage(this.getParent(), this.getQueryEntity()));
        packageInfo.put("VoEntity", joinPackage(this.getParent(), this.getVoEntity()));
        packageInfo.put("DtoEntity", joinPackage(this.getParent(), this.getDtoEntity()));
        packageInfo.put(ConstVal.MAPPER, joinPackage(this.getParent(), this.getMapper()));
        packageInfo.put(ConstVal.XML, joinPackage(this.getParent(), this.getXml()));
        packageInfo.put("Dao", joinPackage(this.getParent(), this.getService()));
        packageInfo.put("DaoImpl", joinPackage(this.getParent(), this.getServiceImpl()));
        packageInfo.put("Service", joinPackage(this.getParent(), this.getCustomizeService()));
        packageInfo.put("Manager", joinPackage(this.getParent(), this.getManager()));
        packageInfo.put("Controller", joinPackage(this.getParent(), this.getController()));
        return packageInfo;
    }


    /**
     * 包配置
     *
     * @return
     */
    public void init() {
        this.setParent(Templates.PACKAGE);     //父节点
        this.setEntity("repository.entity");
        this.setQueryEntity("repository.vo");
        this.setSaveEntity("repository.vo");
        this.setDtoEntity("repository.vo");
        this.setVoEntity("repository.vo");
        this.setMapper("repository.mapper");
        this.setService("repository.dao");
        this.setServiceImpl("repository.dao.impl");
        this.setCustomizeService("service");
        this.setManager("manager");
        this.setController("controller");
    }


    /**
     * 连接父子包名
     *
     * @param parent     父包名
     * @param subPackage 子包名
     * @return 连接后的包名
     */
    private String joinPackage(String parent, String subPackage) {
        if (StringUtils.isEmpty(parent)) {
            return subPackage;
        }
        return parent + StringPool.DOT + subPackage;
    }
}
