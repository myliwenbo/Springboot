package vip.xjdai.io;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 缓冲流
 */
public class BufferedStream {
    @Test
    public void read1() throws Exception {
        File file = new File("test.text");
        BufferedInputStream ipt = new BufferedInputStream(new FileInputStream(file));
        byte[] array = new byte[1024];
        int i = 0;
        int readByte = 0;
        while ((readByte = ipt.read()) != -1) {
            array[i] = (byte) readByte;
            i++;
        }
        System.out.println(new String(array, 0, i));
    }

    @Test
    public void read2() throws Exception {
        File file = new File("test.text");
        BufferedInputStream ipt = new BufferedInputStream(new FileInputStream(file));
        byte[] array = new byte[1024];
        int readByte = 0;
        while ((readByte = ipt.read(array)) != -1) {
            System.out.println(new String(array, 0, readByte));
        }
    }

    @Test
    public void weit() throws Exception {
        File file = new File("test.text");
        //如果第二个参数是true ，则字节将写入文件的末尾而不是开头
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        for (int i = 0; i < 10; i++) {
            String s = "我爱你啊" + i;
            fileOutputStream.write(s.getBytes());
            fileOutputStream.write("\r\n".getBytes());
        }
    }
}
