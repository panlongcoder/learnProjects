package org.example.jdbc.base;

import java.sql.*;

/**
 * @author dragon
 * @since 2021/1/12
 */
public class PreparedStatementTest2 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mybatis_test";
        String sql = "insert into user(name, user_code) value (?, ?)";
        try (Connection connection = DriverManager.getConnection(url, "root", "dragon4369");
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, "mars111111444");
            preparedStatement.setString(2, "123");

            preparedStatement.executeUpdate();

            Savepoint savepoint = connection.setSavepoint();

            preparedStatement.setString(1, "mars222222222");
            preparedStatement.setString(2, "dddd");
            preparedStatement.executeUpdate();

            // connection.rollback(savepoint);

            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
