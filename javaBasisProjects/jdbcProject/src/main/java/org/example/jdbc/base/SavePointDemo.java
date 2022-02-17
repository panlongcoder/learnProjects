package org.example.jdbc.base;

import java.sql.*;

/**
 * @author dragon
 * @since 2021/1/12
 */
public class SavePointDemo {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis_test", "root", "dragon4369");

        connection.setAutoCommit(false);

        String insertSql = "insert into user(name,user_code) values(?, ?)";

        String updateSql = "update user set name = 'dragonasdf' where id = ?";

        PreparedStatement statement = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);

        int count = 5;
        long deleteId = 0;
        for (int i = 0; i < count; i++) {
            statement.setString(1, "dragoon" + i);
            statement.setString(2, "123" + i);

            statement.executeUpdate();

            if (i + 1 == count) {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    deleteId = resultSet.getLong(1);
                }
            }
        }

        Savepoint savepoint = connection.setSavepoint("insertSql");

        if (deleteId == 0) {
            connection.rollback();
        }

        PreparedStatement updateStatement = connection.prepareStatement(updateSql);
        updateStatement.setLong(1, deleteId);
        updateStatement.executeUpdate();

        // connection.rollback(savepoint);

        Savepoint delete = connection.setSavepoint("delete");
        
        String deleteSql = "update user set name = '8888888888888'";

        PreparedStatement deleteStatement = connection.prepareStatement(deleteSql);
        deleteStatement.executeUpdate();

        connection.rollback(delete);

        String selectSql = "select * from user where id = ?";

        PreparedStatement selectStatement = connection.prepareStatement(selectSql);

        selectStatement.setLong(1, deleteId);

        ResultSet resultSet = selectStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("查询到的user对象: id:" + resultSet.getLong(1) + " name:" + resultSet.getString(2));
        }

        connection.commit();
    }
}
