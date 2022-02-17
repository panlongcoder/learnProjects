package org.example.jdbc.base;

import java.sql.*;

/**
 * @author dragon
 * @since 2021/1/12
 */
public class TransactionDemo2 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mybatis_test";
        try (Connection connection = DriverManager.getConnection(url, "root", "dragon4369")) {
            connection.setAutoCommit(false);

            String updateSql = "update user set name = ? where id = ?";

            try (PreparedStatement statement = connection.prepareStatement(updateSql)) {
                statement.setString(1, "mars");
                statement.setLong(2, 1000006);
                statement.executeUpdate();
            }
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
