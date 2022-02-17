package org.example.jdbc.base;

import java.sql.*;

/**
 * 脏读: 一个事务可以读取到 另外一个事务修改但是还没有提交的数据
 *
 * @author dragon
 * @since 2021/1/13
 */
public class DirtyReadTest {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mybatis_test";

        Thread thread1 = new Thread(() -> {
            try {
                Connection connection = DriverManager.getConnection(url, "root", "dragon4369");
                connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                connection.setAutoCommit(false);
                String updateSql = "update user set name = ? where id = 1000045";
                PreparedStatement updateStmt = connection.prepareStatement(updateSql);

                updateStmt.setString(1, "zxdvnaljsjldfjasjlfdjlasjdf");

                updateStmt.executeUpdate();

                connection.commit();

                System.out.println("插入提交成功");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                Connection connection = DriverManager.getConnection(url, "root", "dragon4369");
                connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                connection.setAutoCommit(false);

                PreparedStatement statement = connection.prepareStatement("select * from user where  id = 1000045");
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    long id = resultSet.getLong(1);
                    String name = resultSet.getString(2);
                    String userCode = resultSet.getString(3);
                    System.out.println("主键:" + id + "姓名:" + name + " 编码:" + userCode);
                }
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

    }
}
