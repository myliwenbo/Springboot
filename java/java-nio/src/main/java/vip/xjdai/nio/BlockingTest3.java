package vip.xjdai.nio;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BlockingTest3
{
    @Test
    public void clietSocket() throws Exception
    {
        //1.创建一个通道
        //2.打开一个链接
        //3.获取客户端
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 3669));
        FileChannel   fileChannel   = FileChannel.open(Paths.get("io.text"), StandardOpenOption.READ);
        ByteBuffer    allocate      = ByteBuffer.allocate(1024);
        //发送数据到服务端
        while (fileChannel.read(allocate) != -1) {
            //切换成读模式
            allocate.flip();
            //吧缓冲区的数据写入到管道中
            socketChannel.write(allocate);
            //情况缓冲区
            allocate.clear();
        }
        socketChannel.shutdownOutput();
        //接收服务端的反馈
        while (socketChannel.read(allocate) != -1) {
            System.out.println(1);
            allocate.flip();
            System.out.println(new String(allocate.array(), 0, allocate.limit()));
            allocate.clear();
        }
        socketChannel.close();
        fileChannel.close();

    }

    @Test
    public void serverSocket() throws Exception
    {
        //1. 创建一个通道
        //2. 绑定一个端口
        //3. 获取一个服务端
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open().bind(new InetSocketAddress(3669));
        SocketChannel       socketChannel       = serverSocketChannel.accept();
        //创建一个文件通道
        FileChannel fileChannel = FileChannel.open(Paths.get("io2.text"), StandardOpenOption.WRITE,
                                                   StandardOpenOption.CREATE);
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        //接收服务端的数据
        while (socketChannel.read(allocate) != -1) {
            //切换成读模式
            allocate.flip();
            //把不缓冲区数据写入到文件通道中去
            fileChannel.write(allocate);
            allocate.clear();
        }
        allocate.put("你好啊 NIO".getBytes());
        allocate.flip();
        socketChannel.write(allocate);
        socketChannel.close();
        fileChannel.close();
        serverSocketChannel.close();

    }
}
