package vip.xjdai.secunityadminauthenticationprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vip.xjdai.secunityadminauthenticationprovider.config.AbstractUserDetailsAuthenticationProviderDemo;
import vip.xjdai.secunityadminauthenticationprovider.config.AdminAuthenticationProvider;

@SpringBootApplication
public class SecunityAdminAuthenticationProviderApplication {

    public static void main(String[] args) {
        SpringApplication value = new SpringApplication(SecunityAdminAuthenticationProviderApplication.class);
        // value.setAdditionalProfiles(AdminAuthenticationProvider.class.getSimpleName());
        value.setAdditionalProfiles(AbstractUserDetailsAuthenticationProviderDemo.class.getSimpleName());
        value.run(args);
    }

}
