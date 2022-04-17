package vip.xjdai.viewresolverjsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ViewResolverJspApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ViewResolverJspApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ViewResolverJspApplication.class, args);
    }

}
