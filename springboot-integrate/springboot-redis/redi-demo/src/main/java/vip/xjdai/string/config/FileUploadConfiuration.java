package vip.xjdai.string.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@Configuration
public class FileUploadConfiuration {
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件大小200mb
        factory.setMaxFileSize(DataSize.ofMegabytes(300L));
        //设置总上传数据大小10GB
        factory.setMaxRequestSize(DataSize.ofGigabytes(10L));
        return factory.createMultipartConfig();
    }
}