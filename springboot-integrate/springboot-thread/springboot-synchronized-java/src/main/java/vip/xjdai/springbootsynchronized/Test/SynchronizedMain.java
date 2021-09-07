package vip.xjdai.springbootsynchronized.Test;

public class SynchronizedMain {

    public static void main(final String[] args) {
        final SynchronizedDemo value = new SynchronizedDemo();
        new Thread(value::T1).start();
        new Thread(value::T2).start();
        new Thread(value::T3).start();
    }
}
