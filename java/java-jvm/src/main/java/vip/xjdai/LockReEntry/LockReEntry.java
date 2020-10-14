package vip.xjdai.LockReEntry;

/**
 * 锁重入
 */
public class LockReEntry {

    public static void main(String[] args) {
        LockReEntry lockReEntry = new LockReEntry();
        new Thread(lockReEntry::reEntry1).start();
        new Thread(lockReEntry::reEntry1).start();
    }


    public synchronized void reEntry1() {
        System.out.println("重入1");
        reEntry2();
    }

    public synchronized void reEntry2() {
        System.out.println("重入2");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println(Thread.currentThread().getName());
        reEntry3();
    }

    public synchronized void reEntry3() {
        System.out.println("重入3");
        reEntry4();
    }

    public synchronized void reEntry4() {
        System.out.println("重入4");
        reEntry5();

    }

    public synchronized void reEntry5() {
        System.out.println("重入5");
        System.out.println(Thread.currentThread().getName());

    }
}
