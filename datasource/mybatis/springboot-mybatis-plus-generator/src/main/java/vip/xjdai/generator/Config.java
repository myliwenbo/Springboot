package cn.zingfin.finance.conf;

import java.util.*;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * packConfig说明
 */
public class Config
{

    /**
     * 当前项目路径
     */
    private static final String this_path = Thread.currentThread().getContextClassLoader().getResource(
            "").toString().replace("/target/classes/", "").replace("file:/", "");

    /**
     * 获取parent项目路径
     */
    private static final String PATH = System.getProperty("user.dir");

    private static final String PACKAGE      = "cn.zingfin.finance";
    private static final String MODEL        = PATH + "\\model\\src\\main\\java" + "/com/alijiajituan/model/";
    private static final String MAPPER       = PATH + "\\mapper\\src\\main\\java" + "/com/alijiajituan/mapper/";
    private static final String WEB          = PATH + "\\web\\src\\main\\java" + "/com/alijiajituan/controller/";
    private static final String XML          = PATH + "\\web\\src\\main\\resources\\mapper\\";
    private static final String SERVICE      = PATH + "\\service\\src\\main\\java" + "/com/alijiajituan/service/";
    private static final String SERVICE_IMPL = PATH + "\\service\\src\\main\\java" + "/com/alijiajituan/service/impl/";
    private static final String URL          = "";
    private static final String USER_NAME    = "";
    private static final String PASSWORD     = "";

    /**
     * 包配置
     * @return
     */
    public static PackageConfig createPackageConfig()
    {
        PackageConfig pc = new PackageConfig();     //包配置
        pc.setParent(PACKAGE);                      //父节点
        pc.setController("web.controller");         //生成的pack名称为
        pc.setService("service");                   //生成的pack名称为 ，  vip.xjdai.service
        pc.setServiceImpl("service.impl");          //生成的pack名称为 ，  vip.xjdai.service.impl
        pc.setEntity("model");                      //生成的pack名称为 ，
        pc.setMapper("dal.mapper");                 //生成的pack名称为 ，
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
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
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
        // %s 为占位符
        gc.setEntityName("%s"); // 实体命名方式，就会形成 UserEntity ，如果使用自定义路径则该规则不会生效
        gc.setMapperName("%sMapper"); // 实体命名方式，就会形成 UserMapper ，如果使用自定义路径则该规则不会生效
        gc.setXmlName("%sMapper"); // 实体命名方式，就会形成 UserMapper.xml ，如果使用自定义路径则该规则不会生效
        gc.setServiceName("I%sDao"); // 实体命名方式，就会形成 UserService ，如果使用自定义路径则该规则不会生效
        gc.setServiceImplName("%sDaoImpl"); // 实体命名方式，就会形成 UserServiceImpl ，如果使用自定义路径则该规则不会生效
        gc.setControllerName("%sController"); // 实体命名方式，就会形成 UserController ，如果使用自定义路径则该规则不会生效
        return gc;
    }

    /**
     * 策略配置，可指定需要生成哪些表或者排除哪些表，
     * 参考：https://mp.baomidou.com/config/generator-config.html#%E6%95%B0%E6%8D%AE%E5%BA%93%E8%A1%A8%E9%85%8D%E7%BD%AE
     *
     * @return
     */
    public static StrategyConfig createStrategyConfig()
    { // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel); // 数据库映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);// 数据库表字段映射到实体的命名策略
        strategy.setTablePrefix("t_"); // 此处可以修改为表前缀 例如：表 t_user 生成的对象就会去掉 去掉t_ 最终形成 user
        strategy.setFieldPrefix("tb_"); // 此处可以修改为字段前缀 例如：表 tb_user_name 生成的字段就会去掉tb_ 最终形成 user_name
        // 公共父类
        // strategy.setSuperControllerClass("com.alijiajituan.controller.BaseController");
        strategy.setSuperEntityClass("com.example.finance.repository.entity.BaseDo"); // 自定义继承的Entity类全称
        // strategy.setInclude("要生成的表"); // 需要生成的表,和排除只能2选一
        strategy.setExclude("bak_category_property", "user"); // 需要排除的表，除了排除的表其他的都生成
        // 自定义实体，公共字段
        strategy.setSuperEntityColumns("id", "is_valid", "op_time", "last_ver", "status", "type", "create_time",
                                       "app_id");
        strategy.setVersionFieldName("last_ver"); //乐观锁属性名称
        strategy.setLogicDeleteFieldName("is_valid");//逻辑删除属性名称
        strategy.setEntityLombokModel(true); // 添加lombok模型
        strategy.setRestControllerStyle(true); // 生成 @RestController 控制器
        strategy.setEntityTableFieldAnnotationEnable(true);// 生成字段注解
        strategy.setEntityColumnConstant(true);
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);
        return strategy;
    }

    /**
     * 模板配置
     *
     * @return
     */
    public static TemplateConfig createTemplateConfig()
    {
        // 默认使用的是自带的模板
        TemplateConfig templateConfig = new TemplateConfig();
        // templateConfig.setService("/templates/serviceC.java.vm"); //默认模板
        // templateConfig.setEntity();
        // templateConfig.setService();
        // templateConfig.setController();
        // templateConfig.setMapper()
        // templateConfig.setServiceImpl();
        // templateConfig.setEntity(null);// 如上任何一个模块如果设置 Null 将不生成该模块
        // 自定义模板文件，注意不要带上（.ftl）或者（.vm）, 会根据使用的模板引擎自动识别
        // 自定义模板放在 src/main/resources/templates 目录下, 默认名称可以不配置，也可以自定义模板名称
        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改
        // tc.setXml();
        return templateConfig;
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip)
    {
        Scanner       scanner = new Scanner(System.in);
        StringBuilder help    = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * 自定义配置
     */
    public static InjectionConfig createInjectionConfig()
    {
        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无
        InjectionConfig cfg = new InjectionConfig()
        {
            @Override
            public void initMap()
            {
                Map< String, Object > map = new HashMap< String, Object >();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-rb");
                this.setMap(map);
            }
        };

        List< FileOutConfig > focList = new ArrayList< FileOutConfig >();

        // 调整 model 生成目录
        focList.add(new FileOutConfig("/templates/entity.java.vm")
        {
            @Override
            public String outputFile(TableInfo tableInfo)
            {
                return MODEL + tableInfo.getEntityName() + ".java";
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
        // 调整 service生成目录
        focList.add(new FileOutConfig("/templates/service.java.vm")
        {
            @Override
            public String outputFile(TableInfo tableInfo)
            {
                return SERVICE + tableInfo.getEntityName() + "Service.java";
            }
        });
        // 调整 impl生成目录
        focList.add(new FileOutConfig("/templates/serviceImpl.java.vm")
        {
            @Override
            public String outputFile(TableInfo tableInfo)
            {
                return SERVICE_IMPL + tableInfo.getEntityName() + "ServiceImpl.java";
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
                return XML + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        cfg.setFileOutConfigList(focList);
        return cfg;
    }

}
