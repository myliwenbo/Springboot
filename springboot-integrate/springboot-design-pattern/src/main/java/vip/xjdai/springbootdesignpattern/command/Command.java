package vip.xjdai.springbootdesignpattern.command;

public interface Command {
    /**
     * 执行方法
     */
    void execute(String sql);
}