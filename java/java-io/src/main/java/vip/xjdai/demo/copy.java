package vip.xjdai.demo;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class copy {

    @Test
    public void copyFile() throws Exception {

        BufferedInputStream is = new BufferedInputStream(new FileInputStream("test.text"));
        FileOutputStream fileOutputStream = new FileOutputStream("test2.text");
        byte[] array = new byte[1024];
        int i = 0;
        while ((i = is.read()) != -1) {
            java.lang.String s = new java.lang.String(array, 0, i);
            fileOutputStream.write(array, 0, i);
            System.out.println(s);
        }

    }
}
