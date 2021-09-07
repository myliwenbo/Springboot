package vip.xjdai.profile;

import org.apache.logging.log4j.util.PropertiesUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SpringBootApplication
public class ProfileApplication {

    public static void main(String[] args) throws IOException {
        // ClassLoader.getSystemResourceAsStream("upload.properties");
        InputStream inputStream = ProfileApplication.class.getClassLoader().getResourceAsStream("env.properties");
        Properties value = new Properties();
        value.load(inputStream);
        System.out.println(value.getProperty("username"));
    }


}
