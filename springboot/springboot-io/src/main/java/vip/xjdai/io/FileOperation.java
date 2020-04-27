package vip.xjdai.io;

import java.io.File;
import java.io.IOException;

public class FileOperation {

    public static final String type = ".jar";

    public static void main(String[] args) {
        delete("G:\\技术-视频");
    }

    public static void mvFile() throws IOException {
        Runtime.getRuntime().exec("执行文件mv 操作。");

    }

    public static void deleteDirectory(File f) {
        //获取所有文件
        File[] files = f.listFiles();
        //判断文件是否为空 ,什么也不做
        for (File file : files) {
            if (file.isDirectory()) {
                if (file.list().length > 0) {
                    deleteDirectory(file);
                } else {
                    System.out.print("删除目录的路径：" + file.getPath());
                    if (file.delete()) {
                        System.out.println("--删除成功!");
                    } else {
                        System.out.println("--删除失败!");
                    }
                }
            }
        }

    }

    /**
     * 删除指定文件
     * @param path
     */
    public static void delete(String path) {
        File file = new File(path);// 可以指向一个目录
        search(file);
        deleteDirectory(file);
    }

    private static void search(File f) {
        //获取所有文件
        File[] files = f.listFiles();
        //判断文件是否为空 ,什么也不做
        for (File file : files) {
            if (file.isDirectory()) {
                search(file);
            } else {
                String name = file.getName();
                if (name.contains(type)) {
                    System.out.print("要删除的文件：" + name);
                    if (file.delete()) {
                        System.out.println("删除成功");
                    } else {
                        System.out.println("删除失败");
                    }
                }
            }
        }
    }
}
