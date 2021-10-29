package vip.xjdai.api;

import java.io.File;
import java.io.FileFilter;

public class ListFilesDemo {

    public static void main(String[] args) {
        File srcDir = new File("java");
        //获取该目录下的所有文件..
        File[] files = srcDir.listFiles(new FileFilter() {
            // 设置一个过滤器
            @Override
            public boolean accept(File pathname) {
                // 通过这个过滤器我们可以过滤掉某些目录或者文件..
                return false;
            }
        });
    }
}
