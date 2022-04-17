package vip.xjdai.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.*;

/**
 * Title: MysqlGenerator
 * <p>
 * Description:
 *
 * @author 瞿麦 <a href="mailto:qumai@2dfire.com">;
 * @version V1.0
 * @since 2017/9/11
 */
public class MysqlGenerator
{
    /**
     * <p>
     * MySQL 生成演示
     * </p>
     */
    public static void main(String[] args)
    {
        // 自定义需要填充的字段
        List< TableFill > tableFillList = new ArrayList<>();
        //        tableFillList.add(new TableFill("ASDD_SS", FieldFill.INSERT_UPDATE));

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator().setPackageInfo(
                // 包配置
                new PackageConfig()
                        //                        .setModuleName("")

                //                        .setController("controller")// 这里是控制器包名，默认 web
        ).setCfg(
                // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
                new InjectionConfig()
                {
                    @Override
                    public void initMap()
                    {
                        Map< String, Object > map = new HashMap<>();
                        map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                        this.setMap(map);
                    }
                }.setFileOutConfigList(
                        Collections.< FileOutConfig >singletonList(new FileOutConfig("/templates/mapper.xml.vm")
                        {
                            // 自定义输出文件目录
                            @Override
                            public String outputFile(TableInfo tableInfo)
                            {
                                return "/Users/quspacedragon/Documents/lingmao/finance/src/main/resources/mapper/" + tableInfo.getEntityName() + ".xml";
                                //                        return "/Users/quspacedragon/Documents/lingmao/apm/core/src/main/resources/mapper/" + tableInfo.getEntityName() + ".xml";
                            }
                        })));
        //        .setTemplate(
        //                // 关闭默认 xml 生成，调整生成 至 根目录
        //                new TemplateConfig().setXml(null)
        //                // 自定义模板配置，模板可以参考源码 /mybatis-plus/src/main/resources/template 使用 copy
        //                // 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
        //                // .setController("...");
        //                // .setEntity("...");
        //                // .setMapper("...");
        //                // .setXml("...");
        //                // .setService("...");
        //                // .setServiceImpl("...");
        //        );

        // 执行生成
        mpg.execute();

        // 打印注入设置，这里演示模板里面怎么获取注入内容【可无】
        System.err.println(mpg.getCfg().getMap().get("abc"));
    }
}
