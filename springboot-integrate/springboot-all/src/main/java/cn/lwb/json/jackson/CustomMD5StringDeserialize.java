package cn.lwb.json.jackson;

import java.io.IOException;

import org.springframework.data.redis.core.script.DigestUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomMD5StringDeserialize extends JsonDeserializer<String> {

    @Override
    public String deserialize(JsonParser p,
                              DeserializationContext ctxt) throws IOException,
                                                           JsonProcessingException {
        String text = p.getText();
        String sha1DigestAsHex = DigestUtils.sha1DigestAsHex(text);
        return sha1DigestAsHex;
    }

}