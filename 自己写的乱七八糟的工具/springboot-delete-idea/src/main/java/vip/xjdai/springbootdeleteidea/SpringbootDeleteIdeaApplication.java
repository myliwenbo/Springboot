package vip.xjdai.springbootdeleteidea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FilenameFilter;

public class SpringbootDeleteIdeaApplication {

    private static final String PATH = "F:\\Demo\\gitdemo\\SpringDemo\\spring-cloud-alibaba";
    private static final String DELETE_FIILE = ".idea";
    private static Integer count = 0;

    public static void main(String[] args) {
        File file = new File(PATH);
        search(file, DELETE_FIILE);
        System.out.println(count);
    }

    private static void search(File f, String s1) {
        File[] files = f.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return dir.getName().endsWith(s1);
            }
        });
        //判断文件是否为空 ,如空
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory() && file.getName().endsWith(s1)) {
                    count++;
                    System.out.println("开始删除");
                    delete(file);
                    System.out.println("路径：" + file.getPath());
                } else if (file.isDirectory()) {
                    search(file, s1);
                }
            }
        }
    }

    /**
     * 进入到这个目录，开始逐个删除...
     *
     * @param fileD
     */
    private static void delete(File fileD) {
        //删除失败，当前目录下还有文件
        boolean delete = fileD.delete();
        if (!delete) {
            File[] files = fileD.listFiles();
            for (File file : files) {
                delete(file);
            }
            //删除失败后再次删除..
            fileD.delete();
        }
    }
}
