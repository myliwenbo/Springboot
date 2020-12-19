package vip.xjdai.springbootthreaddemo.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Data
@Configuration
@EnableAsync
public class ThreadPoolConfig
{
    // 获取Java虚拟机的可用的处理器数，最佳线程个数，处理器数*2。根据实际情况调整
    private static final Integer maxPoolSize = Runtime.getRuntime().availableProcessors() * 2;

    private static ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Bean("taskExecutor")
    public TaskExecutor taskExecutor()
    {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程池大小
        executor.setCorePoolSize(1);
        // 设置最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        // 设置队列容量
        executor.setQueueCapacity(100);
        // 设置线程活跃时间（秒）
        executor.setKeepAliveSeconds(5);
        // 线程名字前缀
        executor.setThreadNamePrefix("log-");
        // 设置拒绝策略rejection-policy：当pool已经达到max size的时候，如何处理新任务 CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();
        threadPoolTaskExecutor = executor;
        return executor;
    }

}

