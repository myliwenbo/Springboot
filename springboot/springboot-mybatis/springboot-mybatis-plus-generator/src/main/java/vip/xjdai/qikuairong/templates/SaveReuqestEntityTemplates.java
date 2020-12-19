package vip.xjdai.qikuairong.templates;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

public class SaveReuqestEntityTemplates implements Templates {


    @Override
    public FileOutConfig contextMethod() {
        return new FileOutConfig(SAVE_ENTITY_TEMPLATES) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return SAVE_ENTITY + tableInfo.getEntityName()  + Templates.SAVE_REQUEST_SUFFIX + StringPool.DOT_JAVA;
            }
        };
    }
}
