package vip.xjdai.springbootquartz.task;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class OrderDelay implements Delayed {

    private String orderId;
    private long timeout;

    /**
     * @param orderId 订单ID
     * @param timeout 超时时间
     */
    OrderDelay(String orderId, long timeout) {
        this.orderId = orderId;
        this.timeout = timeout + System.nanoTime();
    }

    // 比较延时，队列里元素的排序依据
    public int compareTo(Delayed other) {
        if (other == this)
            return 0;
        OrderDelay t = (OrderDelay) other;
        long d = (getDelay(TimeUnit.NANOSECONDS) - t.getDelay(TimeUnit.NANOSECONDS));
        return (d == 0) ? 0 : ((d < 0) ? -1 : 1);

    }

    //获取剩余时间
    public long getDelay(TimeUnit unit) {
        return unit.convert(timeout - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    void print() {
        System.out.println(orderId + "编号的订单要删除啦。。。。");
    }

}