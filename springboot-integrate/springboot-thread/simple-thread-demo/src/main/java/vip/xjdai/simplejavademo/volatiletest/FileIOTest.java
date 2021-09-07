package vip.xjdai.simplejavademo.volatiletest;

import java.io.FileWriter;
import java.io.IOException;

public class FileIOTest {
    public static void main(String[] args) throws IOException {
        FileWriter fileReader = new FileWriter("FileOutputStream.text");
        fileReader.append("1");

    }
}
