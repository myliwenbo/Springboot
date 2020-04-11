package vip.xjdai.nio;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 阻塞IO..
 */
public class BlockingTest1
{

    /**
     * 客户端，演示一个客户上传文件的动作
     * @throws Exception
     */
    @Test
    public void nioBlockingSocket() throws Exception
    {
        //1. 创建一个通socket读通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        //2. 创建一个文件通道
        FileChannel open = FileChannel.open(Paths.get("io.text"), StandardOpenOption.READ);
        //3. 创建一个缓存
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        //4. 读取本地文件，然后发送到服务器
        while (open.read(allocate) != -1) {
            //5. 切换成读模式
            allocate.flip();
            //6. 往通道写入数据
            socketChannel.write(allocate);  //往文件通道里面放入数据
            allocate.clear();
        }
        open.close();
        socketChannel.close();

    }

    /**
     * 服务端
     * @throws Exception
     */
    @Test
    public void serverSocket() throws Exception
    {
        //1. 创建一个Socket服务通道
        //2. 绑定一个端口
        //3. 获取客户端连接通道
        ServerSocketChannel bind   = ServerSocketChannel.open().bind(new InetSocketAddress(9898));
        SocketChannel       accept = bind.accept();
        //创建一个文件读取通道
        FileChannel fileChannel = FileChannel.open(Paths.get("io2.text"), StandardOpenOption.WRITE,
                                                   StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        ByteBuffer  allocate    = ByteBuffer.allocate(1024);
        //读取接收客户端发送的文件，写入到服务端中
        while ((accept.read(allocate)) != -1) {
            allocate.flip();//切换成读模式
            fileChannel.write(allocate);//叫数据发送给客户端
            allocate.clear();//清楚缓存
        }
        accept.close();
        fileChannel.close();
        bind.close();
    }
}
