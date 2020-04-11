package vip.xjdai.demo.thread.demo;

import lombok.Data;

/**
 * 阻塞演示... 没OK...
 */
@Data
class BlockTest implements Runnable
{
    private String  tag;
    private Integer count = 50;

    public BlockTest(String tag)
    {
        this.tag = tag;
    }

    @Override
    public void run()
    {
        if (tag.equals("A")) {
            synchronizedA();
        } else {
            asynchronousB();
        }
    }

    /**
     * 表示该代码块属于同步，线程只能一个一个的来
     */
    public synchronized void synchronizedA()
    {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("索引位置：" + count-- + "线程名称：" + Thread.currentThread().getName());
    }

    /**
     *  非同步
     */
    public void asynchronousB()
    {
        System.out.println("索引位置：" + count-- + "----线程名称：" + Thread.currentThread().getName());
    }

    public static void main(String[] args)
    {
        //异步
        //        BlockTest d = new BlockTest("A");
        //同步
        BlockTest d = new BlockTest("B");
        for (int i = 0; i < 25; i++) {
            new Thread(d).start();
            new Thread(d).start();
        }
    }
}