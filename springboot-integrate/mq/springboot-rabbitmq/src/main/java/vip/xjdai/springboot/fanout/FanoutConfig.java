package vip.xjdai.springboot.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {
    /**
     * 队列
     * @return
     */
    @Bean
    public Queue reportPaymentQueue() {
        return new Queue("api.report.payment");
    }

    /**
     * 队列
     * @return
     */
    @Bean
    public Queue reportRefundQueue() {
        return new Queue("api.report.refund");
    }

    /**
     * 创建转换器
     * @return
     */
    @Bean
    public FanoutExchange reportExchange() {
        return new FanoutExchange("reportExchange");
    }

    /**
     * 绑定
     * @param reportPaymentQueue
     * @param reportExchange
     * @return
     */
    @Bean
    public Binding bindingReportPaymentExchange(Queue reportPaymentQueue,
                                                FanoutExchange reportExchange) {
        return BindingBuilder.bind(reportPaymentQueue).to(reportExchange);
    }

    /**
     * 绑定
     * @param reportRefundQueue
     * @param reportExchange
     * @return
     */
    @Bean
    public Binding bindingReportRefundExchange(Queue reportRefundQueue,
                                               FanoutExchange reportExchange) {
        return BindingBuilder.bind(reportRefundQueue).to(reportExchange);
    }
}