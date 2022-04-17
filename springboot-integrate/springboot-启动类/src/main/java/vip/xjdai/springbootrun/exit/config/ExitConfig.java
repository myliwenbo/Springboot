package vip.xjdai.springbootrun.exit.config;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

@Component
public class ExitConfig implements ExitCodeGenerator {
    @Override
    public int getExitCode() {
        // 可以做出一些动作
        System.out.println("退出了");
        return 0;
    }
}
