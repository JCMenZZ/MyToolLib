package cn.lightzz.dbutils;

import cn.lightzz.dbutils.connector.DbToolsPort;

import java.sql.*;

/**
 * 数据库连接工具
 *
 * @author JCLightZZ
 * @version 1.0.0
 * @date 2019/12/25 09:55
 */
public class DbTools implements DbToolsPort {
    private Connection conn = null;

    @Override
    public Connection oracleGetConnection(String connectionMode, String address, String port,
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

    @Override
    public Connection mysqlGetConnection(String address, String port, String username, String password,
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

    @Override
    public void releaseConn(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void releaseConnAndStat(Connection connection, Statement statement) {
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

    @Override
    public void releaseConnAndStatAndRst(Connection connection, Statement statement, ResultSet resultSet) {
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
