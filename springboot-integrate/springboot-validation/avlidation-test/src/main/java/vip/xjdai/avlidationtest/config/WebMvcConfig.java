package vip.xjdai.avlidationtest.config;

// @Configuration
// public class WebMvcConfig implements WebMvcConfigurer {
//
//     @Override
//     public Validator getValidator() {
//         LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
//         // 使用Spring加载国际化资源文件
//         // ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//         // messageSource.setBasename("MyValidationMsg");
//         ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//         // 注意此处名字就随意啦，毕竟交给spring了`.properties`就不需要了哦
//         messageSource.setBasename("MyValidationMsg");
//         messageSource.setCacheSeconds(120); // 缓存时长
//         // messageSource.setFileEncodings(); // 设置编码 UTF-8
//         localValidatorFactoryBean.setValidationMessageSource(messageSource);
//         return localValidatorFactoryBean;
//     }
//
// }