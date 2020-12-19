package vip.xjdai.generator;

import cn.zingfin.finance.FinancingGenerator;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator
{

    public static void main(String[] args)
    {
        // 代码生成器
        AutoGenerator    mpg = new AutoGenerator();
        DataSourceConfig ds  = FinancingGenerator.createDateSource(); //数据源
        mpg.setDataSource(ds);
        GlobalConfig gc = FinancingGenerator.createGlobalConfig(); //全局配置
        mpg.setGlobalConfig(gc);
        PackageConfig pc = FinancingGenerator.createPackageConfig(); //包配置
        mpg.setPackageInfo(pc);
        //这里去添加要生成的表
        StrategyConfig sc = FinancingGenerator.createStrategyConfig("wordbook"); //策略
        mpg.setStrategy(sc);
        TemplateConfig tc = FinancingGenerator.createTemplateConfig();
        mpg.setTemplate(tc);
        InjectionConfig injectionConfig = FinancingGenerator.createInjectionConfig();//自定义配置
        mpg.setCfg(injectionConfig);
        mpg.execute();
    }

}