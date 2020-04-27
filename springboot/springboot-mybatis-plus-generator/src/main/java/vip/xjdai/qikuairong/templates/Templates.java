package vip.xjdai.qikuairong.templates;

import com.baomidou.mybatisplus.generator.config.FileOutConfig;

public interface Templates {


    /**
     * package
     */
    String PACKAGE = "cn.zingfin.finance";


    /**
     * 当前项目路径
     */
    String PATH = System.getProperty("user.dir" ) + "/src/main/java";

    String AUTHOR = "良田美地天下第一牛逼";


    /**
     * 生成的目录
     */
    String PACKAGE_FILE = "/cn/zingfin/finance/";


    /**
     * 模板地址
     */
    String TEMPLATES = "/templates1/";

    String ENTITY = PATH + PACKAGE_FILE + "/repository/entity/";
    String ENTITY_TEMPLATES = "/templates1/entity.java.vm";

    String ENTITY_TDO = PATH + PACKAGE_FILE + "/repository/entity/";
    String ENTITY_TDO_TEMPLATES = "/templates1/dto_entity.java.vm";


    String QUERY_ENTITY = PATH + PACKAGE_FILE + "/repository/vo/";
    String QUERY_ENTITY_TEMPLATES = "/templates1/query_entity.java.vm";


    String SAVE_ENTITY = PATH + PACKAGE_FILE + "/repository/vo/";
    String SAVE_ENTITY_TEMPLATES = "/templates1/save_entity.java.vm";


    String VO_ENTITY = PATH + PACKAGE_FILE + "/repository/vo/";
    String VO_TEMPLATES = "/templates1/vo_entity.java.vm";


    String XML = System.getProperty("user.dir" ) + "/src/main/resources/mapper/";
    String XML_TEMPLATES = "/templates1/xml.xml.vm";

    String MAPPER = PATH + PACKAGE_FILE + "/repository/mapper/";
    String MAPPER_TEMPLATES = "/templates1/mapper.java.vm";


    String DAO = PATH + PACKAGE_FILE + "/repository/dao/";
    String DAO_TEMPLATES = "/templates1/dao.java.vm";


    String DAO_IMPL = PATH + PACKAGE_FILE + "/repository/dao/impl/";
    String DAO_IMPL_TEMPLATES = "/templates1/dao_impl.java.vm";


    String SERVICE = PATH + PACKAGE_FILE + "/service/";
    String SERVICE_TEMPLATES = "/templates1/service.java.vm";


    String MANAGER = PATH + PACKAGE_FILE + "/manager/";
    String MANAGER_TEMPLATES = "/templates1/manager.java.vm";

    String CONTROLLER = PATH + PACKAGE_FILE + "/controller/";
    String CONTROLLER_TEMPLATES = "/templates1/controller.java.vm";

    FileOutConfig contextMethod();

    String SAVE_REQUEST_SUFFIX = "SaveRequest";
    String QUERY_REQUEST_SUFFIX = "QueryRequest";
    String VO_REQUEST_SUFFIX = "Vo";
    String DTO_REQUEST_SUFFIX = "Tdo";
    String MAPPER_SUFFIX = "Mapper";
    String DAO_SUFFIX = "Dao";
    String DAO_IMPL_SUFFIX = "DaoImpl";
    String SERVICE_SUFFIX = "Service";
    String MANAGER_SUFFIX = "Manager";
    String CONTROLLER_SUFFIX = "Controller";


}
