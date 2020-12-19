package vip.xjdai.mysql;


import java.sql.*;

public class MySqlTest {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://192.168.117.141:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM t_user";
        ResultSet rs = statement.executeQuery(sql);
        // 展开结果集数据库
        while(rs.next()){
            // 通过字段检索
            int id  = rs.getInt("id");
            String name = rs.getString("name");
            String url = rs.getString("url");
        }
    }
}
