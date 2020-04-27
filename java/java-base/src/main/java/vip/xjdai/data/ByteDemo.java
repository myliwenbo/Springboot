package vip.xjdai.data;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

public class ByteDemo
{
    
    @Test
    public void TranscodingTest() throws Exception {
        String s="我爱你";
        byte[] bytes = s.getBytes("gbk");
        System.out.println(new String(bytes,"GBK"));
        byte[] bytes1 = s.getBytes(StandardCharsets.UTF_8);
        System.out.println(new String(bytes1));

    }
}
