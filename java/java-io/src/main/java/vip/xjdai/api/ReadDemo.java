package vip.xjdai.api;

import org.junit.Test;

import java.io.*;

public class ReadDemo
{
    @Test
    public void read1() throws Exception
    {
        File file=new File("test.text");
        FileInputStream ipt =new FileInputStream(file);
        byte[] bytes = new byte[1024]; //设置一次读取1024个字节
       //将读取的数据放入到数组中
        int readByte = 0;
        while((readByte = ipt.read(bytes)) != -1){
            String s=new String(bytes, 0, readByte);
            System.out.println(s);
        }
    }
     @Test
     public void weit() throws Exception {
         File file=new File("test.text");
         //如果第二个参数是true ，则字节将写入文件的末尾而不是开头
         FileOutputStream fileOutputStream=  new FileOutputStream(file,true);
         for (int i = 0; i < 10000; i++) {
             String s="我爱你啊"+i;
             fileOutputStream.write(s.getBytes());
             Thread.sleep(500);
         }
     }
}
