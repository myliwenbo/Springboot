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
        mpg.execute();
    }

}