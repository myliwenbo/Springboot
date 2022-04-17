package vip.xjdai.springbootmybatisgenerator;

import org.junit.jupiter.api.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RunCode {
    private static String path;

    static {
        try {
            path = new File("").getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void path() throws Exception {
        System.out.println(path);
        System.out.println(RunCode.class.getResource("").getPath());
        System.out.println(RunCode.class.getResource("/").getPath());
        System.out.println(System.getProperty("user.dir"));

    }
    @Test
    public void Generator() throws Exception {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        File configFile = new File(path + "\\src\\main\\resources\\mysql-mybatis-generator.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        //覆盖之前的文件..
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        for (String warning : warnings) {
            System.out.println(warning);
        }

    }

}