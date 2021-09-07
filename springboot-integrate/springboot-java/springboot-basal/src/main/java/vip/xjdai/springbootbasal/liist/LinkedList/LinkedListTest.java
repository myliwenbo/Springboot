package vip.xjdai.springbootbasal.liist.LinkedList;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class LinkedListTest {
    private final LinkedList<Connection> connectionPool = new LinkedList<>();

    private static int currentCount = 0;

    //创建对象的时候初始化 10个连接
    protected LinkedListTest() {
        //初始化connection个数
        int initCount = 10;
        for (int i = 0; i < initCount; i++) {
            try {
                this.connectionPool.addLast(this.createConnection());
                // 表示目前有10个连接
                currentCount++;
            } catch (Exception e) {
                throw new ExceptionInInitializerError(e);
            }
        }

    }

    private Connection createConnection() throws SQLException {
        //mysql 连接串
        String url = "";
        //用户名
        String user = "";
        //密码
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }


    protected Connection getConnection() throws SQLException {
        synchronized (this.connectionPool) {
            // 如果 池子里面没有了
            if (this.connectionPool.size() > 0) {
                currentCount--;
                return this.connectionPool.removeFirst();
            }
            //c 判断最大值，也就是说超过池子之后可创建的连接
            int maxCount = 20;
            if (currentCount < maxCount) {
                this.createConnection();
                currentCount++;
            }
            // 提示异常没有连接了
            throw new SQLException("no connection");
        }
    }

    //用完连接 ，继续放入到池子中去
    protected void free(Connection conn) {
        synchronized (this.connectionPool) {
            this.connectionPool.addLast(conn);
            currentCount++;
        }
    }
}
