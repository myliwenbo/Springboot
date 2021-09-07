package vip.xjdai.generator.templates;

import com.baomidou.mybatisplus.generator.config.FileOutConfig;

public interface Templates {


    /**
     * package
     */
    String PACKAGE = "co.vip.xjdai";

    /**
     * 当前项目路径
     */
    String PATH = System.getProperty("user.dir") + "/src/main/java/";

    String AUTHOR = "良田美地";


    /**
     * 生成的目录
     */
    String PACKAGE_FILE = PACKAGE.replace(".", "/") + "/";


    /**
     * 模板地址
     */
    String TEMPLATES = "/templates/";

    String ENTITY = PATH + PACKAGE_FILE + "/repository/entity/";
    String ENTITY_TEMPLATES = "/templates/entity.java.vm";

    String ENTITY_TDO = PATH + PACKAGE_FILE + "/repository/vo/";
    String ENTITY_TDO_TEMPLATES = "/templates/dto_entity.java.vm";


    String QUERY_ENTITY = PATH + PACKAGE_FILE + "/repository/vo/";
    String QUERY_ENTITY_TEMPLATES = "/templates/query_entity.java.vm";


    String SAVE_ENTITY = PATH + PACKAGE_FILE + "/repository/vo/";
    String SAVE_ENTITY_TEMPLATES = "/templates/save_entity.java.vm";


    String VO_ENTITY = PATH + PACKAGE_FILE + "/repository/vo/";
    String VO_TEMPLATES = "/templates/vo_entity.java.vm";


    String XML = System.getProperty("user.dir") + "/src/main/resources/mapper/";
    String XML_TEMPLATES = "/templates/xml.xml.vm";

    String MAPPER = PATH + PACKAGE_FILE + "/repository/mapper/";
    String MAPPER_TEMPLATES = "/templates/mapper.java.vm";


    String DAO = PATH + PACKAGE_FILE + "/repository/dao/";
    String DAO_TEMPLATES = "/templates/dao.java.vm";


    String DAO_IMPL = PATH + PACKAGE_FILE + "/repository/dao/impl/";
    String DAO_IMPL_TEMPLATES = "/templates/dao_impl.java.vm";


    String SERVICE = PATH + PACKAGE_FILE + "/service/";
    String SERVICE_TEMPLATES = "/templates/service.java.vm";


    String MANAGER = PATH + PACKAGE_FILE + "/manager/";
    String MANAGER_TEMPLATES = "/templates/manager.java.vm";

    String CONTROLLER = PATH + PACKAGE_FILE + "/controller/";
    String CONTROLLER_TEMPLATES = "/templates/controller.java.vm";

    FileOutConfig contextMethod();

    String SAVE_REQUEST_SUFFIX = "SaveRequest";
    String QUERY_REQUEST_SUFFIX = "QueryRequest";
    String VO_REQUEST_SUFFIX = "Vo";
    String DTO_REQUEST_SUFFIX = "Dto";
    String MAPPER_SUFFIX = "Mapper";
    String DAO_SUFFIX = "Dao";
    String DAO_IMPL_SUFFIX = "DaoImpl";
    String SERVICE_SUFFIX = "Service";
    String MANAGER_SUFFIX = "Manager";
    String CONTROLLER_SUFFIX = "Controller";


    String URL = "jdbc:mysql://106.14.136.81:3306/hnl_financing";
    String USER_NAME = "hnl_financing";
    String PASSWORD = "N^xHa#fG&2U4FPod";

}
