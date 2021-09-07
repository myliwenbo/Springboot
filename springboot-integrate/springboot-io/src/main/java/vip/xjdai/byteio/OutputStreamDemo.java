/**
 * 
 */
package vip.xjdai.byteio;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.Test;

/**
 * @author lwb
 *
 */
public class OutputStreamDemo {

    @Test
    public void fileInputStream() throws IOException {
        File f = new File("aaa.txt"); // 定位文件位置
        OutputStream out = new FileOutputStream(f); // 创建字节输出流连接到文件
        String str = "hhhhhhh啊啊";
        byte[] b = str.getBytes(); //讲数据存入byte数组
        out.write(b); //写数据 
        out.close(); //关闭流
    }

    @Test
    public void bufferedOutputStream() throws IOException {
        File f = new File("aaa.txt"); // 定位文件位置
        OutputStream out = new FileOutputStream(f); // 创建字节输出流连接到文件
        FilterOutputStream bos = new BufferedOutputStream(out);//加入缓冲流
        String str = "hhhhhhh啊啊";
        byte[] b = str.getBytes(); //讲数据存入byte数组
        bos.write(b); //写数据 
        bos.close(); //关闭缓冲流
        out.close(); //关闭流
    }
}
