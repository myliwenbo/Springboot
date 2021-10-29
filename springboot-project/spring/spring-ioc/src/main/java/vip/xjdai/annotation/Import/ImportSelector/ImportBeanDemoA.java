package vip.xjdai.annotation.Import.ImportSelector;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MyImportSelector.class})
public class ImportBeanDemoA {


}
