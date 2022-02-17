package org.example.jdbc.base;

import java.sql.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author dragon
 * @since 2021/1/12
 */
public class BatchInsertDemo {

    public static void main(String[] args) {
        List<User> userList = IntStream.rangeClosed(1, 1000000)
                .mapToObj(count -> {
                    User user = new User();
                    user.setName(String.valueOf(count));
                    user.setUserCode("code" + count);

                    return user;
                }).collect(Collectors.toList());
        long beginTime = System.currentTimeMillis();
        List<User> result = batchInsert(userList);
        long endTime = System.currentTimeMillis();
        // 总花费197358
        // 总花费184415
        System.out.println("总花费" + (endTime - beginTime));
    }

    public static List<User> insert(List<User> userList) {
        if (userList == null || userList.size() == 0) {
            return null;
        }
        String sqlString = "insert into user(name ,user_code) value (?, ?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis_test", "root", "dragon4369");
             PreparedStatement statement = connection.prepareStatement(sqlString, Statement.RETURN_GENERATED_KEYS)) {
            for (int i = 0; i < userList.size(); i++) {
                User userParam = userList.get(i);
                statement.setString(1, userParam.getName());
                statement.setString(2, userParam.getUserCode());

                int affectRows = statement.executeUpdate();
                if (affectRows != 1) {
                    throw new RuntimeException("error");
                }
                // ResultSet resultSet = statement.getGeneratedKeys();
                // if (resultSet.next()) {
                //     userParam.setId(resultSet.getLong(1));
                // }
                statement.clearParameters();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userList;
    }

    public static List<User> batchInsert(List<User> userList) {
        if (userList == null || userList.size() == 0) {
            return null;
        }
        String sqlString = "insert into user(name ,user_code) value (?, ?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis_test", "root", "dragon4369");
             PreparedStatement statement = connection.prepareStatement(sqlString, Statement.RETURN_GENERATED_KEYS)) {
            int begin = 0;
            for (int i = 0; i < userList.size(); ) {
                User userParam = userList.get(i);
                statement.setString(1, userParam.getName());
                statement.setString(2, userParam.getUserCode());

                statement.addBatch();
                if (++i % 10000 == 0 || i == userList.size()) {
                    statement.executeBatch();
                    // ResultSet resultSet = statement.getGeneratedKeys();
                    // while (resultSet != null && resultSet.next()) {
                    //     long id = resultSet.getLong(1);
                    //     User user = userList.get(begin);
                    //     user.setId(id);
                    //     begin++;
                    // }
                    // if (begin != i) {
                    //     throw new RuntimeException("error");
                    // }
                    statement.clearParameters();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userList;
    }


    private static class User {
        private String name;

        private String userCode;

        private Long id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

}
