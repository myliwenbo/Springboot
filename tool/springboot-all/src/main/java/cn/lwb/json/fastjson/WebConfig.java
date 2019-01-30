package cn.lwb.json.fastjson;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * 配置设置fastJSON的优先级高于jackson，注意并不是替换!
 * @author lwb
 *
 */
@Configuration
public class WebConfig {

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        //1、创建FastJson信息转换对象 
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //2、创建FastJsonConfig对象并设定序列化规则  序列化规则详见ChineseSerializerFeature类中
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
            //Boolean字段如果为null,输出为falseJ,而非null
            SerializerFeature.WriteNullBooleanAsFalse,
            //字符类型字段如果为null,输出为"",而非null
            SerializerFeature.WriteNullStringAsEmpty,
            //List字段如果为null,输出为[],而非null
            SerializerFeature.WriteNullListAsEmpty,
            //是否输出值为null的字段,默认为false。
            SerializerFeature.WriteMapNullValue,
            //是否格式化
            SerializerFeature.PrettyFormat,
            ////如果key不为String 则转换为String 比如Map的key为Integer
            SerializerFeature.WriteNonStringKeyAsString);
        List<MediaType> fastMedisTypes = new ArrayList<MediaType>();
        fastMedisTypes.add(MediaType.APPLICATION_JSON_UTF8);//设定Json格式且编码为utf-8
        fastConverter.setSupportedMediaTypes(fastMedisTypes);
        //4、将转换规则应用于转换对象 
        fastConverter.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters(fastConverter);
    }

    // 序列化规则
    public enum ChineseSerializerFeature {
                                          QuoteFieldNames, //输出key时是否使用双引号,默认为true 

                                          UseSingleQuotes, //使用单引号而不是双引号,默认为false

                                          WriteMapNullValue, //是否输出值为null的字段,默认为false 

                                          WriteEnumUsingToString, //Enum输出name()或者original,默认为false

                                          UseISO8601DateFormat, //Date使用ISO8601格式输出，默认为false

                                          WriteNullListAsEmpty, //List字段如果为null,输出为[],而非null 

                                          WriteNullStringAsEmpty, //字符类型字段如果为null,输出为"",而非null 

                                          WriteNullNumberAsZero, //数值字段如果为null,输出为0,而非null 

                                          WriteNullBooleanAsFalse, //Boolean字段如果为null,输出为false,而非null

                                          SkipTransientField, //如果是true，类中的Get方法对应的Field是transient，序列化时将会被忽略。默认为true

                                          SortField, //按字段名称排序后输出。默认为false

                                          @Deprecated
                                          WriteTabAsSpecial, //把\t做转义输出，默认为false

                                          PrettyFormat, //结果是否格式化,默认为false

                                          WriteClassName, //序列化时写入类型信息，默认为false。反序列化是需用到

                                          DisableCircularReferenceDetect, //消除对同一对象循环引用的问题，默认为false

                                          WriteSlashAsSpecial, //对斜杠'/'进行转义

                                          BrowserCompatible, //将中文都会序列化为 XXXX格式，字节数会多一些，但是能兼容IE 6，默认为false

                                          WriteDateUseDateFormat, //全局修改日期格式,默认为false。JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";JSON.toJSONString(obj, SerializerFeature.WriteDateUseDateFormat);

                                          NotWriteRootClassName, //暂不知，求告知

                                          DisableCheckSpecialChar, //一个对象的字符串属性中如果有特殊字符如双引号，将会在转成json时带有反斜杠转移符。如果不需要转义，可以使用这个属性。默认为false 

                                          BeanToArray; //暂不知，求告知

    }

}
