package vip.xjdai.qikuairong.templates;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

public class ManagerTemplates implements Templates {


    @Override
    public FileOutConfig contextMethod() {
        return new FileOutConfig(MANAGER_TEMPLATES) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return MANAGER + tableInfo.getEntityName() + Templates.MANAGER_SUFFIX + StringPool.DOT_JAVA;
            }
        };
    }
}
