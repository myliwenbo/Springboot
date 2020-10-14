package vip.xjdai.IoState;

import com.sun.org.apache.bcel.internal.generic.Visitor;
import lombok.Data;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class User {

    private volatile static boolean tage = true;

    public static void main(String[] args) {
        User user = new User();
        Kernel kernel = new Kernel();
        // 去获取
        new Thread(() -> {
            while (tage) {
                String fd6 = user.recvfrom(kernel, "fd6");
                if (fd6 != null) {
                    System.out.println(fd6);
                    tage = false;
                }
            }
        }).start();
        new Thread(() -> {
            while (tage) {
                System.out.println("看会书...");
            }
        }).start();
        new Thread(() -> {
            while (tage) {
                System.out.println("喝会茶...");
            }
        }).start();
    }

    /**
     * @param kernel
     * @param fd     文件操作符
     * @return
     */
    private String recvfrom(Kernel kernel, String fd) {
        return kernel.read(fd);
        // return
    }
}

@Data
class Kernel {

    private Map<String, String> data = new HashMap<>();

    public String read(String fd) {
        String s = data.get(fd);
        if (s == null) {
            Disk disk = new Disk();
            String query = disk.query(fd);
            data.put(fd, query);
        }
        return data.get(fd);
    }
}

class Disk {

    public String query(String fd) {
        // 假设获取文件特别大
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //根据文件描述符查找
        return "文件";
    }
}
