package vip.xjdai.meta.classMetadata;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.core.type.StandardClassMetadata;
import org.springframework.core.type.classreading.AnnotationMetadataReadingVisitor;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.io.IOException;

public class StandardClassMetadataDemo {

    public static void main(String[] args) throws IOException {

//        // 5.2 不推荐使用了
//        StandardClassMetadata classMetadata = new StandardClassMetadata(StandardClassMetadataDemo.class);
//
//        // 5.2 不推荐使用了
//        StandardAnnotationMetadata annotationMetadata = new StandardAnnotationMetadata(StandardClassMetadataDemo.class);

        // 推荐使用..使用工厂模式来构造~~~构造的就是：
        // StandardAnnotationMetadata
        //      StandardClassMetadata
        AnnotationMetadata introspect = AnnotationMetadata.introspect(StandardClassMetadataDemo.class);
        introspect.getAnnotations();

        SimpleMetadataReaderFactory value = new SimpleMetadataReaderFactory();
        value.getMetadataReader("");
    }
}
