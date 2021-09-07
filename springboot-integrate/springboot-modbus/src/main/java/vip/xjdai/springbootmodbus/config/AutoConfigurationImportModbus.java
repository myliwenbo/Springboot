package vip.xjdai.springbootmodbus.config;

import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.ip.IpParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;

@EnableConfigurationProperties(ModbuProperties.class)
public class AutoConfigurationImportModbus
{
    @Autowired
    private ModbuProperties                 createTcpMaster;
    @Autowired
    @Qualifier("modbusMasterHashMap")
    private HashMap< String, ModbusMaster > masterMap;

    @Bean
    public HashMap< String, ModbusMaster > modbusMasterHashMap() throws ModbusInitException
    {
        HashMap< String, ModbusMaster > masterHashMap = new HashMap<>();
        ModbusFactory                   modbusFactory = new ModbusFactory();

        for (ModbuProperties.ModbusMasterProperties modubsCf : createTcpMaster.getModubsCfs()) {
            IpParameters params = new IpParameters();
            params.setHost(modubsCf.getHost());
            params.setPort(modubsCf.getPort());
            // params.setEncapsulated(true);
            // 设置为true，会导致TimeoutException: request=com.serotonin.modbus4j.ip.encap.EncapMessageRequest@774dfba5",
            ModbusMaster tcpMaster = modbusFactory.createTcpMaster(params, false);// TCP 协议
            // 设置超时时间
            tcpMaster.setTimeout(modubsCf.getTimeout());
            // 设置重连次数
            tcpMaster.setRetries(modubsCf.getRetries());
            //初始化
            tcpMaster.init();
            masterHashMap.put(modubsCf.getHost(), tcpMaster);
        }
        return masterHashMap;
    }

    public ModbusMaster getMaster(String ip)
    {

        ModbusMaster modbusMaster = masterMap.get(ip);
        if (modbusMaster == null) {
            modbusMaster = masterMap.get(ip);
        }
        return modbusMaster;

    }

}
