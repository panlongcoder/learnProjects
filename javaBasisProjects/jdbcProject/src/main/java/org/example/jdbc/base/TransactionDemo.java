package org.example.jdbc.base;

import java.sql.*;

/**
 * @author dragon
 * @since 2021/1/12
 */
public class TransactionDemo {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mybatis_test";
        try (Connection connection = DriverManager.getConnection(url, "root", "dragon4369")) {
            connection.setAutoCommit(false);

            String deleteSql = "delete from user";

            String selectFirstSql = "select * from user limit 1";

            try (PreparedStatement statement = connection.prepareStatement(deleteSql)) {
                int affectRows = statement.executeUpdate();
                System.out.println("删除user表,总共删除了" + affectRows + "条记录");
            }

            try (PreparedStatement selectStatement = connection.prepareStatement(selectFirstSql)) {
                ResultSet resultSet = selectStatement.executeQuery();
                while (resultSet.next()) {
                    System.out.println("查询到user表第一条记录; id:" + resultSet.getLong(1) + " name:" +
                            resultSet.getString(2) + " code:" + resultSet.getString(3));
                }
            }
            connection.commit();
            try (PreparedStatement selectStatement = connection.prepareStatement(selectFirstSql)) {
                ResultSet resultSet = selectStatement.executeQuery();
                while (resultSet.next()) {
                    System.out.println("查询到user表第一条记录; id:" + resultSet.getLong(1) + " name:" +
                            resultSet.getString(2) + " code:" + resultSet.getString(3));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
