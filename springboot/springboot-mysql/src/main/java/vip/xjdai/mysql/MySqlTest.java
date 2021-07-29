package vip.xjdai.mysql;


import java.sql.*;

public class MySqlTest {


    public static void main(String[] args) throws SQLException {
        LinkedListTest value = new LinkedListTest();
        Connection connection = value.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM t_user";
        ResultSet rs = statement.executeQuery(sql);
        // 展开结果集数据库
        while (rs.next()) {
            // 通过字段检索
            int id = rs.getInt("user_id");
            String name = rs.getString("user_name");
            String url = rs.getString("money");
            System.out.println(id);
        }
        value.free(connection);
    }
}
