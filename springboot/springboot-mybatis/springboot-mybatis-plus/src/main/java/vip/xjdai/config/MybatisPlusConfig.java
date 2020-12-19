package vip.xjdai.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//注解开启事物
@EnableTransactionManagement
@Configuration
@MapperScan("vip.xjdai.mapper")
public class MybatisPlusConfig {
    @Bean  //分页插件
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}