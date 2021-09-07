package vip.xjdai.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.google.common.collect.Maps;
import vip.xjdai.generator.config.TemplateConfigEnhance;
import vip.xjdai.generator.templates.Templates;
import vip.xjdai.generator.templates.impl.*;

import java.util.Map;


/**
 * 企快融代码生成器
 */
public class FinancingGenerator {

    /**
     * JDBC
     */
    private static final String URL = "jdbc:mysql://192.168.238.130:3306/test";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";
    private static String[] tables = new String[]{"user"};

    private static final Map<String, Object> map = Maps.newHashMap();

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        //这里去添加要生成的表
        FinancingGenerator.createStrategyConfig(mpg, tables); //策略
        FinancingGenerator.createDateSource(mpg); //数据源
        FinancingGenerator.createGlobalConfig(mpg); //全局配置
        FinancingGenerator.createTemplateConfig(mpg); //配置模板
        FinancingGenerator.createInjectionConfig(mpg);//自定义配置
        //customize.entityExct
        map.put("entityExct", true);//是否开启导入导出
        map.put("BaseDo", "vip.xjdai.pojo.BaseDo;");  //baseDo的路径
        map.put("PageInfo", "com.zing.datacenter.vo.PageInfo;");  //PageInfo的路径
        map.put("BaseRequest", "com.zing.datacenter.request.BaseRequest;");  //PageInfo的路径
        map.put("WebErrorCodeEnums", "com.zing.datacenter.constants.WebErrorCodeEnums;");
        map.put("ExcetListener", " com.zing.datacenter.repository.excel.ExcetListener;");
        mpg.setTemplateEngine(new TemplateConfigEnhance(map));//配置包信息
        mpg.execute();
    }


    /**
     * 数据源配置
     *
     * @return
     */
    public static void createDateSource(AutoGenerator mpg) {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(URL);
        dsc.setUsername(USER_NAME);
        dsc.setPassword(PASSWORD);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert());
        mpg.setDataSource(dsc);
    }

    /**
     * 全局配置
     *
     * @return
     */
    public static void createGlobalConfig(AutoGenerator mpg) {
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(Templates.PATH); // 设置文件生成的目录
        gc.setFileOverride(true); // 是否覆盖原来的文件---- 这里需要注意
        gc.setAuthor(Templates.AUTHOR); // 设置作者~
        gc.setOpen(false); // 打开输出目录
        gc.setEnableCache(false); // XML 二级缓存
        gc.setActiveRecord(true); // 开启 activeRecord 模式
        gc.setBaseResultMap(true); // XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setServiceName("I%sDao"); // 实体命名方式，就会形成 UserService ，如果使用自定义路径则该规则不会生效
        gc.setServiceImplName("%sDaoImpl"); // 实体命名方式，就会形成 UserServiceImpl ，如果使用自定义路径则该规则不会生效
        mpg.setGlobalConfig(gc);

    }

    /**
     * 策略配置，可指定需要生成哪些表或者排除哪些表，
     * 参考：https://mp.baomidou.com/config/generator-config.html#%E6%95%B0%E6%8D%AE%E5%BA%93%E8%A1%A8%E9%85%8D%E7%BD%AE
     *
     * @return
     */
    public static void createStrategyConfig(AutoGenerator mpg, String... include) { // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel); // 数据库映射到实体的命名策略
        // 公共父类
        // strategy.setSuperControllerClass("com.alijiajituan.controller.BaseController");
        strategy.setSuperEntityClass("com.zing.datacenter.repository.entity.support.BaseDo");
        strategy.setInclude(include); // 需要生成的表,和排除只能2选一
        //strategy.setExclude("bak_category_property", "user"); // 需要排除的表，除了排除的表其他的都生成
        // 自定义实体，公共字段
        strategy.setSuperEntityColumns("id", "is_valid", "op_time", "last_ver", "status", "type", "create_time", "app_id");
        strategy.setVersionFieldName("last_ver"); //乐观锁属性名称
        strategy.setLogicDeleteFieldName("is_valid");//逻辑删除属性名称
        strategy.setRestControllerStyle(true); // 生成 @RestController 控制器
        strategy.setEntityLombokModel(true); // 添加lombok模型
        strategy.setEntityColumnConstant(true); //是否生成字段常量
        strategy.setEntityBooleanColumnRemoveIsPrefix(true); // Boolean类型字段是否移除is前缀处理
        mpg.setStrategy(strategy);
    }

    /**
     * 模板配置，如果使用自定义模板和配置，需要将默认模板为NULL!!!!     *
     *
     * @return
     */
    public static void createTemplateConfig(AutoGenerator mpg) {
        TemplateConfig templateConfig = new TemplateConfig();
        // templateConfig.setService("/templates/service.java.vm"); //默认模板
        templateConfig.setEntity(null);// 模块如果设置 Null 将不生成该模块
        templateConfig.setService(null);// 模块如果设置 Null 将不生成该模块
        templateConfig.setServiceImpl(null);// 模块如果设置 Null 将不生成该模块
        templateConfig.setController(null);// 模块如果设置 Null 将不生成该模块
        templateConfig.setMapper(null);// 模块如果设置 Null 将不生成该模块
        templateConfig.setXml(null);// 模块如果设置 Null 将不生成该模块
        // 自定义模板文件，注意不要带上（.ftl）或者（.vm）, 会根据使用的模板引擎自动识别
        // 自定义模板放在 src/main/resources/templates 目录下, 默认名称可以不配置，也可以自定义模板名称
        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改
        mpg.setTemplate(templateConfig);
    }

    /**
     * 自定义配置
     */
    public static void createInjectionConfig(AutoGenerator mpg) {
        StrategyContext templatesList = StrategyContext.getTemplatesList();
        templatesList.contextMethod(new EntityTemplates());
        templatesList.contextMethod(new QueryReuqestEntityTemplates());
        templatesList.contextMethod(new SaveReuqestEntityTemplates());
        templatesList.contextMethod(new VOEntityTemplates());
        templatesList.contextMethod(new XMLTemplates());
        templatesList.contextMethod(new MapperTemplates());
        templatesList.contextMethod(new DAOTemplates());
        templatesList.contextMethod(new DAOImplTemplates());
        templatesList.contextMethod(new ServiceTemplates());
        templatesList.contextMethod(new ManagerTemplates());
        // templatesList.contextMethod(new ControllerTemplates());
        templatesList.getInjectionConfig(mpg);

    }
}
