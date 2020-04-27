package vip.xjdai.nio;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class BlockingTest4
{

    @Test
    public void clietSocket() throws Exception
    {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 3669));
        //非阻塞模式
        socketChannel.configureBlocking(false);
        FileChannel fileChannel = FileChannel.open(Paths.get("io.text"), StandardOpenOption.READ);
        ByteBuffer  allocate    = ByteBuffer.allocate(1024);
        allocate.put(new Date().toString().getBytes());
        allocate.flip();//切换成读模式
        socketChannel.write(allocate);//往服务器传输数据
        socketChannel.close();
        fileChannel.close();

    }

    @Test
    public void serverSocket() throws Exception
    {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open().bind(new InetSocketAddress(3669));
        serverSocketChannel.configureBlocking(false);
        //获取一个选择器
        Selector selector = Selector.open();
        //将通道注册到选择器上，指定监听事件，监听的是接收事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //轮循获取选择器已经`准备就绪的`的事件
        while (selector.select() > 0) {
            //获取当前选择器中所有注册的`选择键（已经就绪的监听事件）`
            Iterator< SelectionKey > iterator = selector.selectedKeys().iterator();
            //获取准备就绪的事件
            while (iterator.hasNext()) {
                //获取事件
                SelectionKey selectionKey = iterator.next();
                //判断具体`接受`事件，是否准备就绪
                if (selectionKey.isAcceptable()) {
                    //获取客户端连接
                    SocketChannel accept = serverSocketChannel.accept();
                    accept.configureBlocking(false); //切换成非阻塞模式
                    //将该通道注册到选择上，监听读就绪事件
                    accept.register(selector, SelectionKey.OP_READ);
                    //判断当前选择的`读事件`，是否准备就绪
                } else if (selectionKey.isReadable()) {
                    SocketChannel channel  = (SocketChannel) selectionKey.channel();
                    ByteBuffer    allocate = ByteBuffer.allocate(1024);
                    while (channel.read(allocate) != -1) {
                        allocate.flip();
                        System.out.println(new String(allocate.array(), 0, allocate.limit()));
                        allocate.clear();
                    }
                }
                iterator.remove();
            }

        }

    }
}
