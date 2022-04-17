package vip.xjdai.common;

import com.baomidou.mybatisplus.generator.config.PackageConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PackageConfigCustomize extends PackageConfig
{
    /**
     * VO包配置
     */
    private String vo = "entity";
}
