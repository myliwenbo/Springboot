package vip.xjdai.nio;

import org.junit.Test;

import java.nio.ByteBuffer;


import java.nio.ByteBuffer;

/**
 * c参考  http://ifeve.com/buffers/
 *  allocate() 用于获取缓冲区
 *
 *  4大属性
 *      capacity：容量大小，声明后不能修改
 *      limit：界限，缓冲区中可以操作数据的大小，超出limit的数据是不能进行读写的
 *      position：位置，表示缓冲区中正在操作的位置
 *
 */

/**
 * 非直接缓冲区，面对的是JVM
 * 直接缓冲区面对的是物理内存
 */
public class BufferAPITest
{


    @Test
    public void Bufff() throws Exception {
        ByteBuffer.allocateDirect(1024);

    }
    @Test
    public void buffer1() throws Exception
    {
        //1. 分配一个指定大小的缓冲区
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        System.out.println(allocate.position());//当前正在可操作的数据
        System.out.println(allocate.limit());//可操作数据的大小
        System.out.println(allocate.capacity());//容器大小，创建不会改变
    }

    @Test
    public void put() throws Exception
    {
        //1. 分配一个指定大小的缓冲区
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        System.out.println(allocate.position());//当前正在可操作的数据
        System.out.println(allocate.limit());//可操作数据的大小
        System.out.println(allocate.capacity());//容器大小，创建不会改变
        allocate.put(new String("ABCD").getBytes());
        //5，为什么是4呢?
        //首先容器是从 0开始算的，也就是说往容器里面添加了4个数据就是 角标 0-1-2-3
        // 所以下次操作的值为4
        System.out.println(allocate.position());
        //1024 ，为什么是1024呢?因为现在是添加数据，那就代表了可添加数据为2014
        System.out.println(allocate.limit());
        System.out.println(allocate.capacity());//容器大小，创建不会改变
    }

    @Test
    public void flip() throws Exception
    {
        //1. 分配一个指定大小的缓冲区
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        System.out.println(allocate.position());//当前正在可操作的数据
        System.out.println(allocate.limit());//可操作数据的大小
        System.out.println(allocate.capacity());//容器大小，创建不会改变
        allocate.put(new String("ABCD").getBytes());
        //5，为什么是4呢?
        //首先容器是从 0开始算的，也就是说往容器里面添加了4个数据就是 角标 0-1-2-3
        // 所以下次操作的值为4
        System.out.println(allocate.position());
        //1024 ，为什么是1024呢?因为现在是添加数据，那就代表了可添加数据为2014
        System.out.println(allocate.limit());
        System.out.println(allocate.capacity());//容器大小，创建不会改变
        //切换读数去
        allocate.flip();
        //因为是0呢 ?因为现在是读数据，所以可操作的位置
        System.out.println(allocate.position()); //0
        //为什么是4呢 ?因为在容器里面数据只有4个，所以界限就是4
        System.out.println(allocate.limit()); //4，
    }

    @Test
    public void get1() throws Exception
    {

        //1. 分配一个指定大小的缓冲区
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        System.out.println(allocate.position());//当前正在可操作的数据
        System.out.println(allocate.limit());//可操作数据的大小
        allocate.put(new String("ABCD").getBytes());
        //5，为什么是4呢?
        //首先容器是从 0开始算的，也就是说往容器里面添加了4个数据就是 角标 0-1-2-3
        // 所以下次操作的值为4
        System.out.println(allocate.position());
        //1024 ，为什么是1024呢?因为现在是添加数据，那就代表了可添加数据为2014
        System.out.println(allocate.limit());
        //切换读数去
        allocate.flip();

        System.out.println(allocate.position()); //因为是0呢 ?因为现在是读数据，准备操作的数据从 角标0开始
        System.out.println(allocate.limit());//为什么是4呢 ?因为在容器里面数据只有4个，所以界限就是4
        byte[]     array      = new byte[2];
        ByteBuffer byteBuffer = allocate.get(array); //读取数据
        System.out.println(new String(array));
        System.out.println(allocate.position()); //为什么是2呢?，因为已经读取了2个数据那再次读取的位置是从角标2开始读取的
        System.out.println(allocate.limit()); //为什么是4呢 ?因为在容器里面数据只有4个，所以界限就是4
        allocate.get(array);
        System.out.println(new String(array));
        System.out.println(allocate.position()); //4 为什么是4呢?因为可操作的时候到了角标4了
        System.out.println(allocate.limit());//4  容器的界限就是4，因为容器里面就4个数据
    }

    @Test
    public void get() throws Exception
    {
        //1. 分配一个指定大小的缓冲区
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        System.out.println(allocate.position());//0
        System.out.println(allocate.limit());//1024
        allocate.put(new String("ABCD").getBytes());
        System.out.println(allocate.position()); //4
        System.out.println(allocate.limit()); //2014
        //切换读数去
        allocate.flip();
        System.out.println(allocate.position()); //0
        System.out.println(allocate.limit()); //4
        byte[] array = new byte[4];
        //读取数据
        ByteBuffer byteBuffer = allocate.get(array);
        System.out.println(new String(array));
        System.out.println(allocate.position()); //4
        System.out.println(allocate.limit());//4
        //如果继续读则会报错，因为已经没有可操作的数据了
        allocate.get(array);
        System.out.println(new String(array));
    }

    @Test
    public void rewind() throws Exception
    {
        //1. 分配一个指定大小的缓冲区
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        System.out.println(allocate.position());//当前正在可操作的数据
        System.out.println(allocate.limit());//可操作数据的大小
        allocate.put(new String("ABCD").getBytes());
        //5，为什么是4呢?
        //首先容器是从 0开始算的，也就是说往容器里面添加了4个数据就是 角标 0-1-2-3
        // 所以下次操作的值为4
        System.out.println(allocate.position());
        //1024 ，为什么是1024呢?因为现在是添加数据，那就代表了可添加数据为2014
        System.out.println(allocate.limit());
        //切换读数去
        allocate.flip();
        //因为是0呢 ?因为现在是读数据，所以可操作的位置
        System.out.println(allocate.position()); //0
        //为什么是4呢 ?因为在容器里面数据只有4个，所以界限就是4
        System.out.println(allocate.limit()); //4，
        try {
            byte[] array = new byte[4];
            //读取数据
            ByteBuffer byteBuffer = allocate.get(array);
            System.out.println(new String(array));
            System.out.println(allocate.position()); //2
            System.out.println(allocate.limit());//4
            allocate.get(array); //第二次读取，报错
            System.out.println(new String(array));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("第二次读取报错");
            allocate.rewind();//可重复读
            System.out.println(allocate.position());
            System.out.println(allocate.limit());
            System.out.println(allocate.capacity());
            byte[] readArray = new byte[allocate.limit()];
            allocate.get(readArray);
            System.out.println(new String(readArray));
        }

    }

    @Test
    public void clear() throws Exception
    {
        //1. 分配一个指定大小的缓冲区
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        System.out.println(allocate.position());//0
        System.out.println(allocate.limit());//1024
        System.out.println(allocate.capacity());//1024
        //添加数据
        allocate.put(new String("ABCD").getBytes());
        System.out.println(allocate.position());//4
        System.out.println(allocate.limit());//1024
        System.out.println(allocate.capacity());//1024
        //清空缓冲区，但是数据还在，只是出于被遗弃状态
        allocate.clear();
        System.out.println(allocate.position());//0
        System.out.println(allocate.limit());//1024
        System.out.println(allocate.capacity());//1024

    }

    @Test
    public void mark() throws Exception
    {
        //1. 分配一个指定大小的缓冲区
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        //添加数据
        allocate.put(new String("abcde").getBytes());
        //切换成读的模式
        allocate.flip();
        byte[] array = new byte[allocate.limit()];
        allocate.get(array, 0, 2);
        System.out.println(new String(array, 0, 2));
        allocate.mark();
        allocate.get(array, 2, 2);
        System.out.println(new String(array, 2, 2));
        try {
            allocate.get(array, 2, 2);
            System.out.println(new String(array, 2, 2));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("报错进入，为什么会报错呢?，因为此时可操作的数据是应该是position是4，所以会报错");
            allocate.reset(); //恢复到 mark的标记
            allocate.get(array, 2, 2);
            System.out.println(new String(array, 2, 2));
        }
        allocate.get(array, 4, 1);
        System.out.println(new String(array, 4, 1));
    }
}
