package vip.xjdai.qikuairong.templates;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

public class DAOImplTemplates implements Templates {


    @Override
    public FileOutConfig contextMethod() {
        return new FileOutConfig(DAO_IMPL_TEMPLATES) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return DAO_IMPL + tableInfo.getEntityName() + Templates.DAO_IMPL_SUFFIX + StringPool.DOT_JAVA;
            }
        };
    }
}
