package vip.xjdai.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator
{


    public static void main(String[] args)
    {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        DataSourceConfig ds = Config.createDateSource();
        mpg.setDataSource(ds);
        GlobalConfig gc = Config.createGlobalConfig();
        mpg.setGlobalConfig(gc);
        PackageConfig pc = Config.createPackageConfig();
        mpg.setPackageInfo(pc);
        TemplateConfig tc = Config.createTemplateConfig();
        mpg.setTemplate(tc);
        StrategyConfig sc = Config.createStrategyConfig();
        mpg.setStrategy(sc);




//
        //        // 自定义配置
        //        InjectionConfig cfg = new InjectionConfig()
        //        {
        //            @Override
        //            public void initMap()
        //            {
        //                // to do nothing
        //            }
        //        };
        //
        //        // 如果模板引擎是 freemarker
        //        String templatePath = "/templates/mapper.xml.ftl";
        //        // 如果模板引擎是 velocity
        //        // String templatePath = "/templates/mapper.xml.vm";
        //
        //        // 自定义输出配置
        //        List< FileOutConfig > focList = new ArrayList<>();
        //        // 自定义配置会被优先输出
        //        focList.add(new FileOutConfig(templatePath)
        //        {
        //            @Override
        //            public String outputFile(TableInfo tableInfo)
        //            {
        //                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
        //                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName() + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
        //            }
        //        });
        //        /*
        //        cfg.setFileCreate(new IFileCreate() {
        //            @Override
        //            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
        //                // 判断自定义文件夹是否需要创建
        //                checkDir("调用默认方法创建的目录");
        //                return false;
        //            }
        //        });
        //        */
        //        cfg.setFileOutConfigList(focList);
        //        mpg.setCfg(cfg);
        mpg.execute();
    }

}