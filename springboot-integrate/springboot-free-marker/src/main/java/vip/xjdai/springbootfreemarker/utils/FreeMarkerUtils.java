package vip.xjdai.springbootfreemarker.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Map;

public class FreeMarkerUtils {

    public static void TestTool(Map<String, Object> root) throws Exception {
        Configuration configuratio = new Configuration(Configuration.VERSION_2_3_23);
        // 设置模板位置
        configuratio.setDirectoryForTemplateLoading(
                new File(System.getProperty("user.dir") + "/src/main/resources/"));
        // 模板类型 ,什么后缀都可以
        Template template = configuratio.getTemplate("index.ftl");
        // 指定输出
        Writer out = new FileWriter(
                new File(System.getProperty("user.dir") + "/src/result1.html"));
        // 使用模板输出
        template.process(root, out);
        out.close();
    }

}
