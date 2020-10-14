package vip.xjdai.generator.templates.impl;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import vip.xjdai.generator.templates.Templates;
;

public class XMLTemplates implements Templates {


    @Override
    public FileOutConfig contextMethod() {
        return new FileOutConfig(XML_TEMPLATES) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return XML + tableInfo.getEntityName() + StringPool.DOT_XML;
            }
        };
    }
}
