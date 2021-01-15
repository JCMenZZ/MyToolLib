package cn.lightzz.utils;


import java.sql.*;

/**
 * 数据库连接工具
 *
 * @author JCLightZZ
 * @version 1.0.0
 * @date 2019/12/25 09:55
 */
public class DbUtils {
    private static Connection conn;

    private DbUtils() {
    }

    /**
     * 对Oracle数据库获取连接对象
     *
     * @param connectionMode 连接时采用的模式（thin/oci）
     * @param address        数据库所在地址，如@localhost
     * @param port           数据库所在端口
     * @param dbName         数据库名称，如XE
     * @param username       oracle数据库所属用户名
     * @param password       该用户的密码
     * @return 返回Connection对象
     * 例如：jdbc:oracle:thin:@127.0.0.1:1521:XE
     */
    public static Connection oracleGetConnection(String connectionMode, String address, String port,
                                                 String dbName, String username, String password) {
        String url = "jdbc:oracle:" + connectionMode + ":@" + address + ":" + port + ":" + dbName;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
        return conn;
    }

    /**
     * 连接Mysql数据库并获得连接对象
     *
     * @param address  mysql数据库所在地址
     * @param port     mysql的端口号
     * @param username 用户名
     * @param password 该用户的密码
     * @param dbName   所连接的数据库名称
     * @return 返回连接对象
     * 例如：jdbc:mysql://localhost:3306/jdbc
     */
    public static Connection mysqlGetConnection(String address, String port, String username, String password,
                                                String dbName) {
        String url = "jdbc:mysql://" + address + ":" + port + "/" + dbName;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
        return conn;
    }

    /**
     * 回收Connection对象
     *
     * @param connection 数据库连接对象
     */
    public static void release(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回收Connection和Statement对象
     *
     * @param connection 数据库连接对象
     * @param statement  数据库结果对象
     */
    public static void release(Connection connection, Statement statement) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回收Connection、Statement和ResultSet对象
     *
     * @param connection 数据库连接对象
     * @param statement  数据库结果对象
     * @param resultSet  数据库结果集对象
     */
    public static void release(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
