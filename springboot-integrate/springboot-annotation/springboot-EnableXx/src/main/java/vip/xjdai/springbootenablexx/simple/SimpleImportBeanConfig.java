package vip.xjdai.springbootenablexx.simple;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({SimpleImportBeanDemoB.class})
public class SimpleImportBeanConfig {
}