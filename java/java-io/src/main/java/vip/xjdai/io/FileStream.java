package vip.xjdai.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 文件流
 */
public class FileStream {
    @Test
    public void read1() throws Exception {
        File file = new File("test.text");
        FileInputStream ipt = new FileInputStream(file);
        int i = 0; //设置一个角标
        int read = ipt.read();//一个数据一个数据的读取
        byte[] bytes1 = new byte[1024]; //设置字节存储容器
        while (read != -1) {// 如果是读取不到数据则返回 -1
            bytes1[i] = (byte) read;
            read = ipt.read();
            i++;
        }
        System.out.println(new String(bytes1, 0, i));
    }

    @Test
    public void read2() throws Exception {
        File file = new File("test.text");
        FileInputStream ipt = new FileInputStream(file);
        int readByte = 0; //代表了返回的角标位置，如果返回 -1 则表示读不到数据了
        byte[] bytes = new byte[1024]; //设置一次读取1024个字节
        while ((readByte = ipt.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, readByte));
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

    @Test
    public void weit1() throws Exception {
        File file1 = new File("test1.text");
        //如果第二个参数是true ，则字节将写入文件的末尾而不是开头
        FileOutputStream fileOutputStream = new FileOutputStream(file1, true);
        File file = new File("test.text");
        FileInputStream ipt = new FileInputStream(file);
        byte[] bytes = new byte[1024]; //设置一次读取1024个字节
        while (ipt.read(bytes) != -1) {
            fileOutputStream.write(bytes);
            fileOutputStream.write("\r\n".getBytes());
        }
    }
}
