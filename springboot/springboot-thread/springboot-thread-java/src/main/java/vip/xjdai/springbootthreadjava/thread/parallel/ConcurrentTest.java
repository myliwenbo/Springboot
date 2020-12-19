package vip.xjdai.springbootthreadjava.thread.parallel;

/**
 * 并行
 */
public class ConcurrentTest {
    private Integer i = 0;

    /**
     * 两个窗口
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        ConcurrentTest concurrentTest = new ConcurrentTest();
        for (int i = 0; i < 5000; i++) {
            new Thread(concurrentTest::addNumber).start();
        }
        System.out.println(concurrentTest.i);
    }

    public void addNumber() {
        this.i += 1;
    }
}
