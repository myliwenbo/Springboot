package vip.xjdai.springbootenablexx.ImportSelector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;


public class EmableImportSelectorConfig implements ImportSelector {
    /**
     * 可以拿到 @EmableImportSelectorConfig 注解的内容
     *
     * @param importingClassMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        String name = EanbleImportSelector.class.getName();
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(name, true));
        return attributes.getStringArray("value");
    }
}
