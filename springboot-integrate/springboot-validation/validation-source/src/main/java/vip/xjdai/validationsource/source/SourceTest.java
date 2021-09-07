package vip.xjdai.validationsource.source;

import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

public class SourceTest {
    public static void main(String[] args) throws Exception {
        /**
         * 是用于解析@RequestBody标注的参数以及处理@ResponseBody标注方法的返回值的。
         * 显然，执行参数校验的逻辑肯定就在解析参数的方法resolveArgument()中：
         */
        RequestResponseBodyMethodProcessor value = new RequestResponseBodyMethodProcessor(null);
        value.resolveArgument(null,null,null,null);
        MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();

        postProcessor.afterPropertiesSet();
        //参考 https://mp.weixin.qq.com/s/G-WOhsQIf6YBHFmrY0na0Q
    }
}
