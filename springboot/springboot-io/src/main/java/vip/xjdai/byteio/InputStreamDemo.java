/**
 * 
 */
package vip.xjdai.byteio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

/**
 * @author lwb
 *
 */
public class InputStreamDemo {

    public static void main(String[] args) throws Exception {
        int b = 1;

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        bout.write(0);
        bout.write(1);
        bout.write(3);
        byte[] buff = bout.toByteArray();
        for (int i = 0; i < buff.length; i++) {
            System.out.println(buff[i]);
        }
        ByteArrayInputStream bin = new ByteArrayInputStream(buff);
        while ((b = bin.read()) != -1) {
            System.out.println(b);
        }
    }

    @Test
    public void fileInputStreamTest() throws IOException {
        File f = new File("aaa.txt"); //定位文件位置
        InputStream in = new FileInputStream(f); //创建字节输入流连接到文件
        byte[] b = new byte[(int) f.length()]; //定义一个数组，用来存放读入的数据 byte数组，根据文件大小来定 (int)f.length()
        int count = 0;
        int temp = 0;
        System.out.println(temp = in.read());
        while ((temp = in.read(b)) != (-1)) { //in.read（）是逐字节读的。当读到文件末尾时候返回-1
            b[count++] = (byte) temp; //将读到的字节存储到byte数组中 
        }
        in.close(); //关闭流
        System.out.println(new String(b)); //打印读取到的字节
    }

    @Test
    public void bufferedInputStreamTest() throws IOException {
        File f = new File("aaa.txt"); //定位文件位置
        InputStream in = new FileInputStream(f); //创建字节输入流连接到文件
        BufferedInputStream bis = new BufferedInputStream(in); //创建缓冲字节流

        byte[] b = new byte[(int) f.length()]; //定义一个数组，用来存放读入的数据 byte数组，根据文件大小来定 (int)f.length()
        int count = 0;
        int temp = 0;
        while ((temp = bis.read()) != (-1)) { //in.read（）是逐字节读的。当读到文件末尾时候返回-1
            b[count++] = (byte) temp; //将读到的字节存储到byte数组中 
        }
        File file = new File("ccc.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream FileOutputStream = new FileOutputStream(file);
        BufferedOutputStream BufferedOutputStream = new BufferedOutputStream(
            FileOutputStream);
        BufferedOutputStream.write(b);
        BufferedOutputStream.close();//关闭流
        FileOutputStream.close();//关闭流
        bis.close(); //关闭流
        in.close();//关闭流
    }
}
