package vip.xjdai.designpatternsdecorator.jdkdemo;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class JdkIoDemo {

    public static void main(String[] args) throws IOException {
        String str = "String与InputStream相互转换";
        byte[] buffer = new byte[1024];

        InputStream in_nocode = new ByteArrayInputStream(str.getBytes());
        BufferedInputStream bufferedInputStream = new BufferedInputStream(in_nocode);
        int tem;
        while ((tem = bufferedInputStream.read()) != -1) {
            //将读取的字节转为字符串对象
            String chunk = new String(buffer, 0, tem);
            System.out.print(chunk);
        }
    }
}
