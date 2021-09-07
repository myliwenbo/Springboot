package vip.xjdai.springbootmodbus.utils;

import org.springframework.context.annotation.Import;
import vip.xjdai.springbootmodbus.config.AutoConfigurationImportModbus;
import vip.xjdai.springbootmodbus.config.ModbusUtil;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({ AutoConfigurationImportModbus.class, ModbusUtil.class, ModbusUtil.class })
public @interface EnableModbus
{

}
