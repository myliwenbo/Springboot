package cn.zingfin.finance;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 企快融代码生成器
 */
public class FinancingGenerator
{

    /**
     * 获取parent项目路径
     */
    private static final String PATH         = System.getProperty("user.dir") + "/src/main/java";
    private static final String PATH_ROOT    = System.getProperty("user.dir");
    /**
     * package
     */
    private static final String PACKAGE      = "cn.zingfin.finance";
    private static final String PACKAGE_FILE = "/cn/zingfin/finance/";
    /**
     * 生成文件的路径
     */
    private static final String MODEL        = PATH + PACKAGE_FILE + "/repository/entity/";
    private static final String MODEL_VO     = PATH + PACKAGE_FILE + "/vo/";
    private static final String MAPPER       = PATH + PACKAGE_FILE + "/repository/mapper/";
    private static final String WEB          = PATH + PACKAGE_FILE + "/controller/";
    private static final String MANAGER      = PATH + PACKAGE_FILE + "/manager/";
    private static final String SERVICE_C    = PATH + PACKAGE_FILE + "/service/";
    private static final String XML          = PATH_ROOT + "\\src\\main\\resources\\mapper\\";
    private static final String SERVICE      = PATH + PACKAGE_FILE + "/repository/dao/";
    private static final String SERVICE_IMPL = PATH + PACKAGE_FILE + "/repository/dao/impl/";
    /**
     * JDBC
     */
    private static final String URL          = "jdbc:mysql://106.14.136.81:3306/hnl_financing";
    private static final String USER_NAME    = "hnl_financing";
    private static final String PASSWORD     = "N^xHa#fG&2U4FPod";

    /**
     * 包配置
     * @return
     */
    public static PackageConfig createPackageConfig()
    {
        PackageConfig pc = new PackageConfig();     //包配置
        pc.setParent(PACKAGE);                      //父节点
        pc.setService("repository.dao");
        pc.setServiceImpl("repository.dao.impl");
        pc.setEntity("repository.entity");
        return pc;
    }

    /**
     * 数据源配置
     *
     * @return
     */
    public static DataSourceConfig createDateSource()
    {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(URL);
        dsc.setUsername(USER_NAME);
        dsc.setPassword(PASSWORD);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert());
        return dsc;
    }

    /**
     * 全局配置
     *
     * @return
     */
    public static GlobalConfig createGlobalConfig()
    {
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(PATH); // 设置文件生成的目录
        gc.setFileOverride(true); // 是否覆盖原来的文件---- 这里需要注意、
        gc.setAuthor("quyl"); // 设置作者~
        gc.setOpen(false); // 打开输出目录
        gc.setEnableCache(false); // XML 二级缓存
        gc.setActiveRecord(true); // 开启 activeRecord 模式
        gc.setBaseResultMap(true); // XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setServiceName("I%sDao"); // 实体命名方式，就会形成 UserService ，如果使用自定义路径则该规则不会生效
        gc.setServiceImplName("%sDaoImpl"); // 实体命名方式，就会形成 UserServiceImpl ，如果使用自定义路径则该规则不会生效
        return gc;
    }

    /**
     * 策略配置，可指定需要生成哪些表或者排除哪些表，
     * 参考：https://mp.baomidou.com/config/generator-config.html#%E6%95%B0%E6%8D%AE%E5%BA%93%E8%A1%A8%E9%85%8D%E7%BD%AE
     *
     * @return
     */
    public static StrategyConfig createStrategyConfig(String... include)
    { // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel); // 数据库映射到实体的命名策略
        // 公共父类
        // strategy.setSuperControllerClass("com.alijiajituan.controller.BaseController");
        strategy.setSuperEntityClass("vip.xjdai.common.BaseDo"); // 自定义继承的Entity类全称
        strategy.setInclude(include); // 需要生成的表,和排除只能2选一
        //        strategy.setExclude("bak_category_property", "user"); // 需要排除的表，除了排除的表其他的都生成
        // 自定义实体，公共字段
        strategy.setSuperEntityColumns("id", "is_valid", "op_time", "last_ver", "status", "type", "create_time",
                                       "app_id");
        strategy.setVersionFieldName("last_ver"); //乐观锁属性名称
        strategy.setLogicDeleteFieldName("is_valid");//逻辑删除属性名称
        strategy.setRestControllerStyle(true); // 生成 @RestController 控制器
        strategy.setEntityLombokModel(true); // 添加lombok模型
        strategy.setEntityColumnConstant(true); //是否生成字段常量
        strategy.setEntityBooleanColumnRemoveIsPrefix(true); // Boolean类型字段是否移除is前缀处理
        return strategy;
    }

    /**
     * 模板配置
     *
     * @return
     */
    public static TemplateConfig createTemplateConfig()
    {

        TemplateConfig templateConfig = new TemplateConfig();
        // templateConfig.setService("/templates/serviceC.java.vm"); //默认模板
        templateConfig.setEntity(null);// 模块如果设置 Null 将不生成该模块
        templateConfig.setService(null);// 模块如果设置 Null 将不生成该模块
        templateConfig.setController(null);// 模块如果设置 Null 将不生成该模块
        templateConfig.setMapper(null);// 模块如果设置 Null 将不生成该模块
        templateConfig.setServiceImpl(null);// 模块如果设置 Null 将不生成该模块
        templateConfig.setXml(null);// 模块如果设置 Null 将不生成该模块
        // 自定义模板文件，注意不要带上（.ftl）或者（.vm）, 会根据使用的模板引擎自动识别
        // 自定义模板放在 src/main/resources/templates 目录下, 默认名称可以不配置，也可以自定义模板名称
        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改
        return templateConfig;
    }

    /**
     * 自定义配置
     */
    public static InjectionConfig createInjectionConfig()
    {
        // 注入自定义配置
        InjectionConfig cfg = new InjectionConfig()
        {
            @Override
            public void initMap()
            {
                //没啥用
            }
        };

        List< FileOutConfig > focList = new ArrayList<>();

        // 调整 model 生成目录
        focList.add(new FileOutConfig("/templates/entity.java.vm")
        {
            public String outputFile(TableInfo tableInfo)
            {
                return MODEL + tableInfo.getEntityName() + ".java";
            }
        });
        // 调整 VO 生成目录
        focList.add(new FileOutConfig("/templates/entityVO.java.vm")
        {
            @Override
            public String outputFile(TableInfo tableInfo)
            {
                return MODEL_VO + tableInfo.getEntityName() + "Vo.java";
            }
        });
        // 调整 Dao生成目录
        focList.add(new FileOutConfig("/templates/service.java.vm")
        {
            @Override
            public String outputFile(TableInfo tableInfo)
            {

                return SERVICE + "I" + tableInfo.getEntityName() + "Dao.java";
            }
        });
        // 调整 DaoImpl生成目录
        focList.add(new FileOutConfig("/templates/serviceImpl.java.vm")
        {
            @Override
            public String outputFile(TableInfo tableInfo)
            {
                return SERVICE_IMPL + tableInfo.getEntityName() + "DaoImpl.java";
            }
        });
        // 调整 Service生成目录
        focList.add(new FileOutConfig("/templates/serviceC.java.vm")
        {
            @Override
            public String outputFile(TableInfo tableInfo)
            {

                return SERVICE + "I" + tableInfo.getEntityName() + ".java";
            }
        });

        // 修改生成 mapper的路径
        focList.add(new FileOutConfig("/templates/mapper.java.vm")
        {
            @Override
            public String outputFile(TableInfo tableInfo)
            {
                return MAPPER + tableInfo.getEntityName() + "Mapper.java";
            }
        });
        // 修改生成 XML的路径
        focList.add(new FileOutConfig("/templates/mapper.xml.vm")
        {
            @Override
            public String outputFile(TableInfo tableInfo)
            {
                return XML + tableInfo.getEntityName() + ".xml";
            }
        });
        // 调整 controller生成目录
        focList.add(new FileOutConfig("/templates/controller.java.vm")
        {
            @Override
            public String outputFile(TableInfo tableInfo)
            {
                return WEB + tableInfo.getEntityName() + "Controller.java";
            }
        });
        //Manager 生成
        focList.add(new FileOutConfig("/templates/manager.java.vm")
        {
            @Override
            public String outputFile(TableInfo tableInfo)
            {
                return MANAGER + tableInfo.getEntityName() + "Manager.java";
            }
        });
        //Service 生成
        focList.add(new FileOutConfig("/templates/service.java.vm")
        {
            @Override
            public String outputFile(TableInfo tableInfo)
            {
                return SERVICE_C + tableInfo.getEntityName() + "Service.java";
            }
        });

        cfg.setFileOutConfigList(focList);
        return cfg;
    }

}
