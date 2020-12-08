package vip.xjdai.swagger2ui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2//注解开启 swagger2 功能
public class SwaggerConfig {

    @Bean
    public Docket config() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(this.productApiInfo()).select()// 选择一个构造器
                .apis(RequestHandlerSelectors.basePackage("cn.lwb"))// 要扫描的controller
                .paths(PathSelectors.any()).build()// 部署
                .pathMapping("/")// 设置访问的前缀 不设置默认是 ${IP}:${HOST}/**ui.html
                .genericModelSubstitutes(DeferredResult.class).forCodeGeneration(true)// 将其设置为true以便使文档代码生成友好
                .useDefaultResponseMessages(false)// 初始化信息
                ;

    }

    private ApiInfo productApiInfo() {
        /**
         * 新版本
         */
        return new ApiInfoBuilder()
                //页面标题
                .title("xxxxx系统数据接口文档")
                //创建人
                .contact(new Contact("MarryFeng", "http://www.baidu.com", ""))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述").build();
    }
}