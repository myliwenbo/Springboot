package vip.xjdai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = { HibernateJpaAutoConfiguration.class, //拒绝启动的时候查找JPA配置
                                   DataSourceAutoConfiguration.class }) // 拒绝启动的时候连接数据库
public class SpringbootManagerPermissionApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(SpringbootManagerPermissionApplication.class, args);
    }

}
