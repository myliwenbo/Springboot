package vip.xjdai.qikuairong.config;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;
import vip.xjdai.qikuairong.templates.Templates;

/**
 * 增强表
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TableInfoConfigEnhance extends TableInfo {

    private String entity = "";
    private String entityHump = "";

    private String saveEntity = "";
    private String saveEntityHump = "";

    private String queryEntity = "";
    private String queryEntityHump = "";

    private String voEntity = "";
    private String voEntityHump = "";

    private String dtoEntity = "";
    private String dtoEntityHump = "";

    private String mapper= "";

    private String dao= "";
    private String daoHump= "";

    private String daoImpl = "";
    private String daoImplHump = "";

    private String service = "";
    private String serviceHump = "";

    private String manager = "";
    private String managerHump = "";


    public TableInfoConfigEnhance(TableInfo tableInfo) {
        BeanUtils.copyProperties(tableInfo, this);

        this.setEntity(tableInfo.getEntityName());
        this.setEntityHump(tableInfo.getEntityPath());

        this.setSaveEntity(tableInfo.getEntityName() + Templates.SAVE_REQUEST_SUFFIX);
        this.setSaveEntityHump(tableInfo.getEntityPath() + Templates.SAVE_REQUEST_SUFFIX);

        this.setQueryEntity(tableInfo.getEntityName() + Templates.QUERY_REQUEST_SUFFIX);
        this.setQueryEntityHump(tableInfo.getEntityPath() + Templates.QUERY_REQUEST_SUFFIX);

        this.setVoEntity(tableInfo.getEntityName() + Templates.VO_REQUEST_SUFFIX);
        this.setVoEntityHump(tableInfo.getEntityPath() + Templates.VO_REQUEST_SUFFIX);

        this.setDtoEntity(tableInfo.getEntityName() + Templates.DTO_REQUEST_SUFFIX);
        this.setDtoEntityHump(tableInfo.getEntityPath() + Templates.DTO_REQUEST_SUFFIX);

        this.setMapper(tableInfo.getEntityName() + Templates.MAPPER_SUFFIX);


        this.setDao(tableInfo.getEntityName() + Templates.DAO_SUFFIX);
        this.setDaoHump(tableInfo.getEntityPath() + Templates.DAO_SUFFIX);

        this.setDaoImpl(tableInfo.getEntityName() + Templates.DAO_IMPL_SUFFIX);
        this.setDaoImplHump(tableInfo.getEntityPath() + Templates.DAO_IMPL_SUFFIX);
        this.setService(tableInfo.getEntityName() + Templates.SERVICE_SUFFIX);
        this.setServiceHump(tableInfo.getEntityPath() + Templates.SERVICE_SUFFIX);
        this.setManager(tableInfo.getEntityName() + Templates.MANAGER_SUFFIX);
        this.setManagerHump(tableInfo.getEntityPath() + Templates.MANAGER_SUFFIX);

    }

}
