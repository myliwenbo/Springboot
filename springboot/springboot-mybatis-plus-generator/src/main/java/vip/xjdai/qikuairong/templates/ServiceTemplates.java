package vip.xjdai.qikuairong.templates;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

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
