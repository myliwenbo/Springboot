package vip.xjdai.springboot.headers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeadersConfig {
    /**
     * 创建队列
     * @return
     */
    @Bean
    public Queue creditBankQueue() {
        return new Queue("credit.bank");
    }

    /**
     * 创建队列
     * @return
     */
    @Bean
    public Queue creditFinanceQueue() {
        return new Queue("credit.finance");
    }

    /**
     * 创建转换器
     * @return
     */
    @Bean
    public HeadersExchange creditBankExchange() {
        return new HeadersExchange("creditBankExchange");
    }

    /**
     * 创建转换器
     * @return
     */
    @Bean
    public HeadersExchange creditFinanceExchange() {
        return new HeadersExchange("creditFinanceExchange");
    }

    /**
     * 
     * @return
     */
    @Bean
    public Binding bindingCreditAExchange(Queue creditBankQueue,
                                          HeadersExchange creditBankExchange) {
        Map<String, Object> headerValues = new HashMap<>();
        headerValues.put("type", "cash");
        headerValues.put("aging", "fast");
        return BindingBuilder.bind(creditBankQueue).to(creditBankExchange)
            .whereAll(headerValues).match();
    }

    /**
     * 
     * @param creditFinanceQueue
     * @param creditFinanceExchange
     * @return
     */
    @Bean
    public Binding bindingCreditBExchange(Queue creditFinanceQueue,
                                          HeadersExchange creditFinanceExchange) {
        Map<String, Object> headerValues = new HashMap<>();
        headerValues.put("type", "cash");
        headerValues.put("aging", "fast");
        return BindingBuilder.bind(creditFinanceQueue).to(creditFinanceExchange)
            .whereAny(headerValues).match();
    }
}