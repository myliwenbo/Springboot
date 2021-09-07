package vip.xjdai.springbootinitializr.config;

import io.spring.initializr.generator.project.contributor.ProjectContributor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

// 用于生成个性化文件
@Configuration
public class FileConfig {

     @Bean
     public ProjectContributor helpMDFileContributor() {
         return projectRoot -> {
             Path file = Files.createFile(projectRoot.resolve("HELP.md"));
             try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(file))) {
                 writer.println("生成文件的内容");
             }
         };
     }

    @Bean
    public ProjectContributor applicationYmlFileContributor() {
        return projectRoot -> {
            Path file = Files.createFile(projectRoot.resolve("src/main/resources/application.yml"));
            try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(file))) {
                writer.println("");
            }
        };
    }
}




