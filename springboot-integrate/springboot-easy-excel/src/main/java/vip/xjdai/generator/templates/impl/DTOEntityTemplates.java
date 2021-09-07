package vip.xjdai.generator.templates.impl;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import vip.xjdai.generator.templates.Templates;


public class DTOEntityTemplates implements Templates {

    @Override
    public FileOutConfig contextMethod() {
        return new FileOutConfig(ENTITY_TDO_TEMPLATES) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return ENTITY_TDO + tableInfo.getEntityName() + Templates.DTO_REQUEST_SUFFIX + StringPool.DOT_JAVA;
            }
        };
    }
}
