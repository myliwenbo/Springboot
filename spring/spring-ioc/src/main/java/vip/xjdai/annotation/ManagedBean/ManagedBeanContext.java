package vip.xjdai.annotation.ManagedBean;

import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import javax.annotation.ManagedBean;
import java.util.Arrays;

public class ManagedBeanContext {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(context, true);
        scanner.addExcludeFilter(new AnnotationTypeFilter(Aspect.class));
        scanner.addExcludeFilter(new AnnotationTypeFilter(ManagedBean.class));
//        scanner.addIncludeFilter(new AnnotationTypeFilter(Aspect.class));
        int beanCount = scanner.scan("vip.xjdai.annotation.ManagedBean");
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

    }
}
