package vip.xjdai.springbootwebsocket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("vip.xjdai.springbootwebsocket.mapper") //将项目中对应的mapper类的路径加进来就可以了
@SpringBootApplication
public class SpringbootWebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebsocketApplication.class, args);
    }

}
