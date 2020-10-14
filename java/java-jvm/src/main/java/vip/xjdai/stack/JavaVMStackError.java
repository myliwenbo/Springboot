package vip.xjdai.stack;

/**
 * 虚拟机栈异常演示：StackOverflowError
 */
public class JavaVMStackError {

    public Integer index = 0;

    public void loop() {
        index++;
        loop();
    }

    public static void main(String[] args) {
        JavaVMStackError value = new JavaVMStackError();
        try {
            value.loop();
        } catch (Throwable e) {
            System.out.println(value.index);
            e.printStackTrace();
        }
    }
}
