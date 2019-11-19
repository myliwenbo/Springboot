package vip.xjdai.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author lwb
 *
 */
public class JSONUtil {
    /**
     * JSON 格式化
     */
    public static final SerializerFeature[] DEFAULT_FORMAT;
    static {
        DEFAULT_FORMAT = new SerializerFeature[] { SerializerFeature.WriteDateUseDateFormat,
                                                   SerializerFeature.WriteEnumUsingToString,
                                                   SerializerFeature.WriteNonStringKeyAsString,
                                                   SerializerFeature.QuoteFieldNames,
                                                   SerializerFeature.SkipTransientField, SerializerFeature.SortField,
                                                   SerializerFeature.PrettyFormat };
    }

    public static <T> T toBean(final String jsonStr, final Class<T> beanClass)
    {
        BeanUtil.requireNonNull(jsonStr, "jsonStr is null");
        final JSONObject jo = JSON.parseObject(jsonStr);
        return JSON.toJavaObject(jo, beanClass);
    }

    public static <T> String toJson(final T obj)
    {
        BeanUtil.requireNonNull((Object) obj, "obj is null");
        return JSON.toJSONString((Object) obj, JSONUtil.DEFAULT_FORMAT);
    }

}
