package vip.xjdai.springbootinitializr.config;


import com.alibaba.fastjson.JSON;
import io.spring.initializr.generator.buildsystem.BomContainer;
import io.spring.initializr.generator.buildsystem.DependencyContainer;
import io.spring.initializr.generator.buildsystem.PropertyContainer;
import io.spring.initializr.generator.buildsystem.maven.MavenBuild;
import io.spring.initializr.generator.buildsystem.maven.MavenPlugin;
import io.spring.initializr.generator.buildsystem.maven.MavenPluginContainer;
import io.spring.initializr.generator.spring.build.BuildCustomizer;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Field;
import java.util.TreeMap;
import java.util.stream.Stream;

@Configuration
public class ProjectConfig {

    @Bean
    //如果是 maven
    // @ConditionalOnBuildSystem(MavenBuildSystem.ID)
    // 如果是 war 才装载这个 Bean
    // @ConditionalOnPackaging(WarPackaging.ID)
    public BuildCustomizer<MavenBuild> removeSpringBootTest() {
        return (build) -> {
            removeBoms(build.boms());
            removeDependencies(build.dependencies());
            removePlugins(build.plugins());
            removeProperty(build.properties());
            System.out.println(JSON.toJSONString(build));
        };
    }

    @SneakyThrows
    public static void removeProperty(PropertyContainer properties) {
        Class<? extends PropertyContainer> aClass = properties.getClass();
        //根据属性名字获取属性，能获取private
        Field propertiesValue = aClass.getDeclaredField("properties");
        //暴力反射,只要修饰符为 private 必须设置可见
        propertiesValue.setAccessible(true);
        propertiesValue.set(properties, new TreeMap<>());
        //根据属性名字获取属性，能获取private
        Field field = aClass.getDeclaredField("versions");
        //暴力反射,只要修饰符为 private 必须设置可见
        field.setAccessible(true);
        field.set(properties, new TreeMap<>());
    }

    public static void removePlugins(MavenPluginContainer mavenPluginContainer) {
        Stream<MavenPlugin> values = mavenPluginContainer.values();
        values.forEach(mavenPlugin -> {
            System.out.println(mavenPlugin.getArtifactId());
        });
        mavenPluginContainer.remove("org.springframework.boot", "spring-boot-maven-plugin");

    }

    public static void removeDependencies(DependencyContainer dependencies) {
        dependencies.ids().forEach(System.out::println);
        dependencies.remove("test");

    }

    public static void removeBoms(BomContainer boms) {
        boms.ids().forEach(System.out::println);
        boms.remove("spring-boot");

    }

}
