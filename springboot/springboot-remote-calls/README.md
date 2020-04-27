# springboot-httpclient
- SpringBoot整合HttpClient服务。





# @Retryable-重试机制

- 发送消息失败,调用远程服务失败,争抢锁失败,等等,这些错误可能是因为网络波动造成的,等待过后重处理就能成功.通常来说,会用try/catch,while循环之类的语法来进行重处理,但是这样的做法缺乏统一性,并且不是很方便,要多写很多代码.然而`spring-retry`却可以通过注解,在不入侵原有业务逻辑代码的方式下,优雅的实现重处理功能.

1. 在启动类上加上`@EnableRetry`

   ```java
   @SpringBootApplication
   @EnableRetry //启动类开启retry
   public class SpringbootApplication {
   
       public static void main(String[] args) {
           SpringApplication.run(SpringbootApplication.class, args);
       }
   }
   
   ```

2. 列子

   ```java
   // value={A异常.class,B异常.class}
   // maxAttempts =重试次数
   // backoff = @Backoff(value = 每次重试延迟毫秒数)
   @Retryable(value = { Exception.class,
                       ArithmeticException.class }, maxAttempts = 5, backoff = @Backoff(value = 1000))
   public String doGet(String url) throws Exception {
       // 声明 http get 请求
       HttpGet httpGet = new HttpGet(url);
       System.out.println("重新调用");
       int i = 10 / 0;
       // 装载配置信息
       httpGet.setConfig(config);
       // 发起请求
       CloseableHttpResponse response = this.httpClient.execute(httpGet);
       // 判断状态码是否为200
       if (response.getStatusLine().getStatusCode() == 200) {
           // 返回响应体的内容
           return EntityUtils.toString(response.getEntity(), "UTF-8");
       }
       return null;
   }
   ```

   

