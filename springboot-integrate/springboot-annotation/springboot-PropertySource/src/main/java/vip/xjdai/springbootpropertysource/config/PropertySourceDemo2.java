package vip.xjdai.springbootpropertysource.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("/test.properties")
public class PropertySourceDemo2 {
}
