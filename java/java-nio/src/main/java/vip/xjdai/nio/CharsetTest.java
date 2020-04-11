package vip.xjdai.nio;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;

public class CharsetTest
{
    @Test
    public void charsetTest() throws Exception
    {
        System.out.println(StandardCharsets.UTF_8);
        Charset        gbk            = Charset.forName("GBK");
        CharsetEncoder charsetEncoder = gbk.newEncoder();
        CharsetDecoder charsetDecoder = gbk.newDecoder();
        CharBuffer     allocate       = CharBuffer.allocate(1024);
        allocate.put("我爱你呀，么么哒");
        allocate.flip();
        ByteBuffer encode = charsetEncoder.encode(allocate);
        for (int i = 0; i < encode.limit(); i++) {
            System.out.println(encode.get(i));
        }
        CharBuffer decode = charsetDecoder.decode(encode);
        System.out.println(decode.toString());
        System.out.println(decode.length());
        System.out.println(decode.limit());

    }
}
