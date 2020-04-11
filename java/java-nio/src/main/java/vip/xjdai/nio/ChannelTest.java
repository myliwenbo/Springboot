package vip.xjdai.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 1. 用于源节点和目标节点的连接，主要用于负责数据传输
 * 2. 本身不存储数据，需要配合Buffer（缓冲区）使用
 * 3. 实现
 *      1. File         文件通道
 *          FileInputStream/FileOutputStream
 *          RandomAccessFile
 *      2. socket       网络通信
 *      3. serverSocket 网络通信
 *      4. Datagram     网络通信
 *
 * 4. 获取通道
 *      1. 通过 getChannel() 方法
 *      2. 通过 open() 方法
 *      3. Files的工具类 new ByteChannel();
 */

/**
 * 非直接缓冲区，面对的是JVM
 * 直接缓冲区面对的是物理内存
 */
public class ChannelTest
{

    /**
     * 分散读取和聚集写入
     * @throws Exception
     */
    @Test
    public void opren3() throws Exception
    {
        RandomAccessFile randomAccessFile = new RandomAccessFile("io.text", "rw");
        FileChannel      channel          = randomAccessFile.getChannel();
        ByteBuffer       buffer1          = ByteBuffer.allocate(100);
        ByteBuffer       buffer2          = ByteBuffer.allocate(4082);
        //分散读
        ByteBuffer[]     byteBuffers      = { buffer1, buffer2 };
        channel.read(byteBuffers);
        for (ByteBuffer byteBuffer : byteBuffers) {
            byteBuffer.flip();// 切换成读模式
        }
        System.out.println(new String(byteBuffers[0].array(),0,byteBuffers[0].limit()));
        System.out.println(new String(byteBuffers[1].array(),0,byteBuffers[1].limit()));
        RandomAccessFile write = new RandomAccessFile("io1.text", "rw");
        FileChannel channel1 = write.getChannel();
        channel1.write(byteBuffers);
    }

    /**
     * 通道直接的数据传输（直接缓冲区）
     * @throws Exception
     */
    @Test
    public void open2() throws Exception
    {
        FileChannel read = FileChannel.open(Paths.get("E:/竹开工作.zip"), StandardOpenOption.READ);
        FileChannel write = FileChannel.open(Paths.get("E:/竹开工作1.zip"), StandardOpenOption.WRITE,
                                             StandardOpenOption.READ, StandardOpenOption.CREATE);
        //准备把读取数据送到哪里去
        read.transferTo(0, read.size(), write);
        //准备从哪里读取数据
        write.transferFrom(read, 0, read.size());
        read.close();
        write.close();
    }

    /**
     * 直接缓冲区，（内存映射）
     * @throws Exception
     */
    @Test
    public void open1() throws Exception
    {
        FileChannel read = FileChannel.open(Paths.get("E:/竹开工作.zip"), StandardOpenOption.READ);
        FileChannel write = FileChannel.open(Paths.get("E:/竹开工作1.zip"), StandardOpenOption.WRITE,
                                             StandardOpenOption.READ, StandardOpenOption.CREATE);
        //内存映射
        MappedByteBuffer readMap  = read.map(FileChannel.MapMode.READ_ONLY, 0, read.size());
        MappedByteBuffer writeMap = write.map(FileChannel.MapMode.READ_WRITE, 0, read.size());
        //相对于原来是直接操作缓冲区，没有操作通道了
        byte[] readArray = new byte[readMap.limit()];
        readMap.get(readArray);
        writeMap.put(readArray);

    }

    /**
     * 利用通道操文件（非直接缓冲区），面对的是JVM
     * @throws Exception
     */
    @Test
    public void open() throws Exception
    {

        FileChannel read = FileChannel.open(Paths.get("io.text"), StandardOpenOption.READ);
        FileChannel write = FileChannel.open(Paths.get("io3.text"), StandardOpenOption.WRITE, StandardOpenOption.CREATE,
                                             StandardOpenOption.APPEND);
        //获取BUffer
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        while (read.read(allocate) != -1) {
            allocate.flip();
            write.write(allocate);
            allocate.clear();
        }
    }

    /**
     * 利用通道操文件（非直接缓冲区），面对的是JVM
     * @throws Exception
     */
    @Test
    public void fileChannel() throws Exception
    {
        //1 .通过通道完成文件的复制
        FileInputStream  fileInputStream  = new FileInputStream("io.text");
        FileOutputStream fileOutputStream = new FileOutputStream("io1.text");
        //获取通道
        FileChannel channel  = fileInputStream.getChannel();
        FileChannel channel1 = fileOutputStream.getChannel();
        //获取BUffer
        ByteBuffer allocate = ByteBuffer.allocate(1024);

        //读取数据到缓冲区中
        while ((channel.read(allocate)) != -1) {
            //切换成读模式
            allocate.flip();
            //将数据写入到缓冲区中
            channel1.write(allocate);
            //情况缓冲区
            allocate.clear();
        }

    }
}
