package vip.xjdai.springbootimg.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceWebConfig implements WebMvcConfigurer {

    private static String IMG_PATH = "C:\\Users\\Administrator\\Pictures\\";

    /**
     * 静态资源处理
     **/
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //表示文件路径，这里的意思是 所有/xxxx/开头的请求 都会去后面配置的路径下查找资源
        registry.addResourceHandler("/**")
                //表示要开放的资源
                .addResourceLocations("file:" + IMG_PATH);
    }
}
