package vip.xjdai.meta.classMetadata;

import org.junit.Test;
import org.springframework.core.type.classreading.AnnotationMetadataReadingVisitor;

public class AnnotationMetadataReadingVisitorDemo {

    public static void main(String[] args) {
        AnnotationMetadataReadingVisitor value = new AnnotationMetadataReadingVisitor(AnnotationMetadataReadingVisitorDemo.class.getClassLoader());
        System.out.println(value.getClassName());
        System.out.println(value.isInterface());
    }

    public interface isInterface {
    }

    @Test
    public void isInterface() throws Exception {
        AnnotationMetadataReadingVisitor value = new AnnotationMetadataReadingVisitor(isInterface.class.getClassLoader());
        System.out.println(value.isInterface());
    }
}

