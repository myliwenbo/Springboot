package vip.xjdai.nio;

import org.junit.Test;

import java.io.File;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 演示一个文件上传的动作
 */
public class BlockingTest2
{

    @Test
    public void socketClient() throws Exception
    {
        //创建socket通道
        SocketChannel open        = SocketChannel.open(new InetSocketAddress(3669));
        FileChannel   fileChannel = FileChannel.open(Paths.get("io2.text"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);
        //创建缓存
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        //读取数据到缓冲区
        while (open.read(allocate) != -1) {
            allocate.flip();//切换成读模式
            fileChannel.write(allocate);//数据推送到客户端
            allocate.clear();//清空
        }
    }

    @Test
    public void socketServer() throws Exception
    {
        //1. 创建一个socket通道
        //2. 打开socket客户端通道
        SocketChannel accept = ServerSocketChannel.open().bind(new InetSocketAddress("127.0.0.1", 3669)).accept();
        //创建一个文件通道
        FileChannel fileChannel = FileChannel.open(Paths.get("io.test"), StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (fileChannel.read(buffer) != -1) {
            buffer.flip();
            accept.write(buffer);
            buffer.clear();
        }
    }
}
