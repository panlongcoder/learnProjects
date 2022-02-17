package org.example.jdbc.base;

import java.sql.*;

/**
 *
 * @author dragon
 * @since 2021/1/11
 */
public class ConnectionTest {

    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis_test", "root", "dragon4369")
             ; Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("select * from user ")) {
                if (resultSet != null) {
                    while (resultSet.next()) {
                        long id = resultSet.getLong(1);
                        String name = resultSet.getString("name");
                        String userCode = resultSet.getString("user_code");
                        Time createTime = resultSet.getTime("create_time");
                        Time updateTime = resultSet.getTime(5);
                        System.out.println(id + " " + name + " " + userCode + "  " + createTime + " " + updateTime);
                    }
                }
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }

    }
}
