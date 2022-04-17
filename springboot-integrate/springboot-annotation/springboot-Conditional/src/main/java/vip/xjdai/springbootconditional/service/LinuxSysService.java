package vip.xjdai.springbootconditional.service;

public class LinuxSysService implements SysService {
    @Override
    public void sysHandle() {
        System.out.println("我是Linux");
    }
}
