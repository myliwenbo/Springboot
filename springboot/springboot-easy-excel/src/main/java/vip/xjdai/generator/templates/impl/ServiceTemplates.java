package vip.xjdai.generator.templates.impl;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import vip.xjdai.generator.templates.Templates;
;

public class ServiceTemplates implements Templates {


    @Override
    public FileOutConfig contextMethod() {
        return new FileOutConfig(SERVICE_TEMPLATES) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return SERVICE + tableInfo.getEntityName()  + Templates.SERVICE_SUFFIX + StringPool.DOT_JAVA;
            }
        };
    }
}
