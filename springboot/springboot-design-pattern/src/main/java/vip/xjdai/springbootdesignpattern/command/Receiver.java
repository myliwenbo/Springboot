package vip.xjdai.springbootdesignpattern.command;

public class Receiver {
    /**
     * 真正执行命令相应的操作
     */
    public void action(String sql) {
        System.out.println("执行：" + sql);
    }
}