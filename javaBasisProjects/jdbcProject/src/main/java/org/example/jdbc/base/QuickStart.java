package org.example.jdbc.base;


import java.sql.*;
import java.util.Properties;

/**
 * jdbc quick start
 *
 * @author dragon
 */
public class QuickStart {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Driver driver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(driver, () -> System.out.println("driver action 运行了"));

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis_test", "root", "dragon4369");

        DatabaseMetaData metaData = connection.getMetaData();
        System.out.println(metaData);

        int transactionIsolation = connection.getTransactionIsolation();
        System.out.println("当前连接数据库的隔离级别:" + transactionIsolation);

        String catalog = connection.getCatalog();
        System.out.println("catalog:" + catalog);

        Properties clientInfo = connection.getClientInfo();
        System.out.println("客户端连接信息:" + clientInfo);

        boolean autoCommit = connection.getAutoCommit();
        System.out.println("当前连接是否自动提交:" + autoCommit);

        int networkTimeout = connection.getNetworkTimeout();


        System.out.println("驱动等待数据库请求完成的等待超时时间:" + networkTimeout);

        String schema = connection.getSchema();

        System.out.println("mysql的schema:" + schema);

        boolean readOnly = connection.isReadOnly();
        System.out.println("当前连接是否是只读:" + readOnly);

        boolean isDelete = false;
        DriverManager.deregisterDriver(driver);
    }
}
