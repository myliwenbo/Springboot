package vip.xjdai.qikuairong.templates;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

public class ControllerTemplates implements Templates {


    @Override
    public FileOutConfig contextMethod() {
        return new FileOutConfig(CONTROLLER_TEMPLATES) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return CONTROLLER + tableInfo.getEntityName() + Templates.CONTROLLER_SUFFIX + StringPool.DOT_JAVA;
            }
        };
    }
}
