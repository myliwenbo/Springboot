# 说明

* 主要开启熔断功能

# 开启熔断

1. 找到消费者
2. 找到消费者启动类，加上`@EnableCircuitBreaker` 注解
3. 如果开启了负载均衡和熔断，可以使用`@SpringCloudApplication`这个注解替换到其他注解

# 测试熔断

1. 断开（服务提供者）
2. 分别访问
   2. http://localhost:9000/helloHystrix
   3. http://localhost:9000/hello  会发现会出现错误，但是上面两个却有正常的信息返回

