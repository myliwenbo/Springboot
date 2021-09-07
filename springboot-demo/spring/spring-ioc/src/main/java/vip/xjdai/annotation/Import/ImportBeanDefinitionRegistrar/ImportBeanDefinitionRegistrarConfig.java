package vip.xjdai.annotation.Import.ImportBeanDefinitionRegistrar;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MyImportBeanDefinitionRegistrar.class)
public class ImportBeanDefinitionRegistrarConfig {

}
