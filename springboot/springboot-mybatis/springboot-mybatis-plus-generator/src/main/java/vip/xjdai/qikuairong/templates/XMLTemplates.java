package vip.xjdai.qikuairong.templates;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

public class XMLTemplates implements Templates {


    @Override
    public FileOutConfig contextMethod() {
        return new FileOutConfig(XML_TEMPLATES) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return XML + tableInfo.getEntityName() + Templates.VO_REQUEST_SUFFIX + StringPool.DOT_XML;
            }
        };
    }
}
