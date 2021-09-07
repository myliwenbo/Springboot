package vip.xjdai.qikuairong.config;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.google.common.collect.Maps;
import lombok.Data;
import lombok.EqualsAndHashCode;
import vip.xjdai.qikuairong.templates.Templates;

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
    private String tdoEntity = "";
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
        packageInfo.put("DtoEntity", joinPackage(this.getParent(), this.getVoEntity()));
        packageInfo.put(ConstVal.MAPPER, joinPackage(this.getParent(), this.getMapper()));
        packageInfo.put(ConstVal.XML, joinPackage(this.getParent(), this.getXml()));
        packageInfo.put("Dao", joinPackage(this.getParent(), this.getService()));
        packageInfo.put("DaoImpl", joinPackage(this.getParent(), this.getServiceImpl()));
        packageInfo.put("Service", joinPackage(this.getParent(), this.getCustomizeService()));
        packageInfo.put("Manager", joinPackage(this.getParent(), this.getManager()));
        packageInfo.put("Controller", joinPackage(this.getParent(), this.getController()));
        return packageInfo;
    }

//    public void setClass() {
//        packageInfo.put("EntityClass", packageInfo.get());
//        packageInfo.put("SaveEntityClass",  packageInfo.get());
//        packageInfo.put("QueryEntityClass",  packageInfo.get());
//        packageInfo.put("VoEntityClass",  packageInfo.get());
//        packageInfo.put("TdoEntityClass",  packageInfo.get());
//        packageInfo.put(ConstVal.MAPPER, packageInfo.get());
//        packageInfo.put(ConstVal.XML,  packageInfo.get());
//        packageInfo.put("DaoClass",  packageInfo.get());
//        packageInfo.put("DaoImplClass",  packageInfo.get());
//        packageInfo.put("ServiceClass",  packageInfo.get());
//        packageInfo.put("ManagerClass",  packageInfo.get());
//        packageInfo.put("ControllerClass",  packageInfo.get());
//    }


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
        this.setTdoEntity("repository.vo");
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
