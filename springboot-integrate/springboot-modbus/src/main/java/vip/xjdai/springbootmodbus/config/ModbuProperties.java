package vip.xjdai.springbootmodbus.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "spring.modbus", ignoreUnknownFields = true)
@Data
public class ModbuProperties
{
    private List< ModbusMasterProperties > modubsCfs;

    @Data
    static class ModbusMasterProperties
    {
        /**
         *IP
         */
        private String  host;
        /**
         * port
         */
        private Integer port;
        /**
         * 超时时间
         */
        private Integer timeout;
        /**
         * 重连次数
         */
        private Integer retries;

        /**
         * 协议，暂时不用..我的本意想着通过批量创建协议的 TODO 暂定吧
         */
        //        private List< ModbuProtocol > protocol;
    }
}
