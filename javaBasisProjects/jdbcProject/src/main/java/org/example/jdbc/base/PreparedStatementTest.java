package org.example.jdbc.base;

import java.sql.*;

/**
 * @author dragon
 * @since 2021/1/12
 */
public class PreparedStatementTest {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mybatis_test";
        String sql = "insert into user(name, user_code) value (?, ?)";
        try (Connection connection = DriverManager.getConnection(url, "root", "dragon4369");
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, "mars");
            preparedStatement.setString(2, "123");

            int affectRows = preparedStatement.executeUpdate();
            if (affectRows > 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet != null && resultSet.next()) {
                    System.out.println("返回的名称:" + resultSet.getString(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
