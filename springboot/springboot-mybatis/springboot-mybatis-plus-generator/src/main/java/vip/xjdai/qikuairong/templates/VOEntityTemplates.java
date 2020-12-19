package vip.xjdai.qikuairong.templates;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

public class VOEntityTemplates implements Templates {


    @Override
    public FileOutConfig contextMethod() {
        return new FileOutConfig(VO_TEMPLATES) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return VO_ENTITY + tableInfo.getEntityName() + Templates.VO_REQUEST_SUFFIX + StringPool.DOT_JAVA;
            }
        };
    }
}
