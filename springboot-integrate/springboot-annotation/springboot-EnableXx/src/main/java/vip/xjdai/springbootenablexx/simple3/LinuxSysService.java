package vip.xjdai.springbootenablexx.simple3;

public class LinuxSysService implements SysService {
    @Override
    public void sysHandle() {
        System.out.println("我是Linux");
    }
}
