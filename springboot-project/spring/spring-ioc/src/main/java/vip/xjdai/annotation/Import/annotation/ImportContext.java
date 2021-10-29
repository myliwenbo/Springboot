package vip.xjdai.annotation.Import.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("vip.xjdai.annotation.Import.annotation")
public class ImportContext {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportContext.class);
    }
}
