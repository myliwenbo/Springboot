package cn.lwb.json.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomDoubleSerialize extends JsonSerializer<Object> {

    /**
     *@param value 要序列化的值;
     *@param gen 生成器，用于输出生成的Json内容
     *@param serializers 序列化器提供程序，可以获取序列化器
     */
    @Override
    public void serialize(Object value, JsonGenerator gen,
                          SerializerProvider serializers) throws IOException {
        gen.writeNull();
    }

}
