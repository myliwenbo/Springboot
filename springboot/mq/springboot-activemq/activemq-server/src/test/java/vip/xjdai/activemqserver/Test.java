package vip.xjdai.activemqserver;

import org.springframework.context.ApplicationContext;

import java.nio.charset.Charset;
import java.util.Map;

public class Test
{
    public static void main(String[] args) {
        String c=null;
        Map<String, Charset> charsets = Charset.availableCharsets();
        for (Map.Entry<String, Charset> entry : charsets.entrySet()) {
            System.out.println(entry.getKey());
        }

    }
}
