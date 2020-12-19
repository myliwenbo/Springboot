package vip.xjdai.springbootzookeepertest.test;

import lombok.SneakyThrows;
import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

public class ZookeeperTest {
    static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws Exception {

        ZooKeeper zooKeeper = new ZooKeeper("192.168.117.141:2181", 5000, new Watcher() {
            @SneakyThrows
            @Override
            public void process(WatchedEvent event) {
                // Event.KeeperState.SyncConnected  建立连接
                Event.KeeperState state = event.getState();
                Event.EventType type = event.getType();
                System.out.println("调用");
                if (Event.KeeperState.SyncConnected == state && Event.EventType.None == type) {
                    //唤醒线程
                    countDownLatch.countDown();
                }

            }
        });
        // 阻塞线程
        countDownLatch.await();
        System.out.println("主线程");
        zooKeeper.close();
    }

    public void temporaryNode(ZooKeeper zooKeeper, String node, String data) throws Exception {
        String sss = zooKeeper.create(node,
                data.getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL); //临时节点， 当 zk.close() 后便删除
        System.out.println(sss);
    }

    public static void createNode(ZooKeeper zooKeeper, String node, String data) throws Exception {
        // 子节点 /nodeParent/node
        // 顶级节点 /node
        String ss = zooKeeper.create("/" + node,
                data.getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);  //CreateMode.PERSISTENT 表示永久节点
        System.out.println(ss);

    }

    public static void delete(ZooKeeper zooKeeper, String node, String data) throws Exception {
        // version -1 跳过版本检查
        zooKeeper.delete("/" + node, -1, new AsyncCallback.VoidCallback() {
            @Override
            public void processResult(int rc, String path, Object ctx) {
                // 0 回调成功
                // -4 端口连接
                // -110 指定节点存在
                // -112 会话过期
                System.out.println(rc);
                // path 路径
                System.out.println(path);
                System.out.println(ctx);
            }
        }, "a");

    }


}


