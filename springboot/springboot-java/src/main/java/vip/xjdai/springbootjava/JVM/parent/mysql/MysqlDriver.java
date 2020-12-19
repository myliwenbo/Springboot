package vip.xjdai.springbootjava.JVM.parent.mysql;

import org.springframework.util.ClassUtils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;

public class MysqlDriver {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://192.168.117.141:3306/test";
        Connection conn = java.sql.DriverManager.getConnection(url, "root", "root");

    }
}
