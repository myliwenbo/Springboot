package vip.xjdai.qikuairong.templates;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

public class DAOTemplates implements Templates {


    @Override
    public FileOutConfig contextMethod() {
        return new FileOutConfig(DAO_TEMPLATES) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return DAO + tableInfo.getEntityName() + Templates.DAO_SUFFIX + StringPool.DOT_JAVA;
            }
        };
    }
}
