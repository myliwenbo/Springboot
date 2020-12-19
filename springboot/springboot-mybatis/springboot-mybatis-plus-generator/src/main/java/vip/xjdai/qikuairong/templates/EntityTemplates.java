package vip.xjdai.qikuairong.templates;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

public class EntityTemplates implements Templates {

    @Override
    public FileOutConfig contextMethod() {
        return new FileOutConfig(ENTITY_TEMPLATES) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return ENTITY + tableInfo.getEntityName() + StringPool.DOT_JAVA;
            }
        };
    }
}
