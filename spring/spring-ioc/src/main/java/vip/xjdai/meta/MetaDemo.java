package vip.xjdai.meta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.HashMap;

// 准备一个Class类 作为Demo演示
@Repository("repositoryName")
@Service("serviceName")
@EnableAsync
class MetaDemo extends HashMap<String, String> implements Serializable {
    private static class InnerClass {
    }
 
    @Autowired
    private String getName() {
        return "demo";
    }
    public static void main(String[] args) {

        StandardAnnotationMetadata metadata = new StandardAnnotationMetadata(MetaDemo.class, true);

        // 演示ClassMetadata的效果
        System.out.println("==============ClassMetadata==============");
        ClassMetadata classMetadata = metadata;
        System.out.println(classMetadata.getClassName()); //com.fsx.maintest.MetaDemo
        System.out.println(classMetadata.getEnclosingClassName()); //null  如果自己是内部类此处就有值了
        System.out.println(StringUtils.arrayToCommaDelimitedString(classMetadata.getMemberClassNames())); //com.fsx.maintest.MetaDemo$InnerClass 若木有内部类返回空数组[]
        System.out.println(StringUtils.arrayToCommaDelimitedString(classMetadata.getInterfaceNames())); // java.io.Serializable
        System.out.println(classMetadata.hasSuperClass()); // true(只有Object这里是false)
        System.out.println(classMetadata.getSuperClassName()); // java.util.HashMap

        System.out.println(classMetadata.isAnnotation()); // false（是否是注解类型的Class，这里显然是false）
        System.out.println(classMetadata.isFinal()); // false
        System.out.println(classMetadata.isIndependent()); // true(top class或者 static inner class，就是独立可new的)

        // 演示AnnotatedTypeMetadata的效果
        System.out.println("==============AnnotatedTypeMetadata==============");
        AnnotatedTypeMetadata annotatedTypeMetadata = metadata;
        System.out.println(annotatedTypeMetadata.isAnnotated(Service.class.getName())); // true（依赖的AnnotatedElementUtils.isAnnotated这个方法）
        System.out.println(annotatedTypeMetadata.isAnnotated(Component.class.getName())); // true

        System.out.println(annotatedTypeMetadata.getAnnotationAttributes(Service.class.getName())); //{value=serviceName}
        System.out.println(annotatedTypeMetadata.getAnnotationAttributes(Component.class.getName())); // {value=repositoryName}（@Repository的value值覆盖了@Service的）
        System.out.println(annotatedTypeMetadata.getAnnotationAttributes(EnableAsync.class.getName())); // {order=2147483647, annotation=interface java.lang.annotation.Annotation, proxyTargetClass=false, mode=PROXY}

        // 看看getAll的区别：value都是数组的形式
        System.out.println(annotatedTypeMetadata.getAllAnnotationAttributes(Service.class.getName())); // {value=[serviceName]}
        System.out.println(annotatedTypeMetadata.getAllAnnotationAttributes(Component.class.getName())); // {value=[, ]} --> 两个Component的value值都拿到了，只是都是空串而已
        System.out.println(annotatedTypeMetadata.getAllAnnotationAttributes(EnableAsync.class.getName())); //{order=[2147483647], annotation=[interface java.lang.annotation.Annotation], proxyTargetClass=[false], mode=[PROXY]}

        // 演示AnnotationMetadata子接口的效果（重要）
        System.out.println("==============AnnotationMetadata==============");
        AnnotationMetadata annotationMetadata = metadata;
        System.out.println(annotationMetadata.getAnnotationTypes()); // [org.springframework.stereotype.Repository, org.springframework.stereotype.Service, org.springframework.scheduling.annotation.EnableAsync]
        System.out.println(annotationMetadata.getMetaAnnotationTypes(Service.class.getName())); // [org.springframework.stereotype.Component, org.springframework.stereotype.Indexed]
        System.out.println(annotationMetadata.getMetaAnnotationTypes(Component.class.getName())); // []（meta就是获取注解上面的注解,会排除掉java.lang这些注解们）

        System.out.println(annotationMetadata.hasAnnotation(Service.class.getName())); // true
        System.out.println(annotationMetadata.hasAnnotation(Component.class.getName())); // false（注意这里返回的是false）

        System.out.println(annotationMetadata.hasMetaAnnotation(Service.class.getName())); // false（注意这一组的结果和上面相反，因为它看的是meta）
        System.out.println(annotationMetadata.hasMetaAnnotation(Component.class.getName())); // true

        System.out.println(annotationMetadata.hasAnnotatedMethods(Autowired.class.getName())); // true
        annotationMetadata.getAnnotatedMethods(Autowired.class.getName()).forEach(methodMetadata -> {
            System.out.println(methodMetadata.getClass()); // class org.springframework.core.type.StandardMethodMetadata
            System.out.println(methodMetadata.getMethodName()); // getName
            System.out.println(methodMetadata.getReturnTypeName()); // java.lang.String
        });
    }
}
 
 
