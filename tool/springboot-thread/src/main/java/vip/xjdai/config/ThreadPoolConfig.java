package vip.xjdai.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@EnableAsync
public class ThreadPoolConfig {

    //其他

    @Bean
    public Executor defaultThreadPool() {
        ThreadPoolTaskScheduler executor = new ThreadPoolTaskScheduler();
        executor.setPoolSize(10);//线程大小
        executor.setThreadPriority(1);//优先级
        executor.setThreadNamePrefix("spring");//名称前缀
        executor.initialize();
        return executor;
    }

}