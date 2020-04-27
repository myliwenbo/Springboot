package vip.xjdai.demo;

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
