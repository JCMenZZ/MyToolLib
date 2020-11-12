package cn.lightzz.dbutils.connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 数据库连接工具接口
 *
 * @author JCLightZZ
 * @date 2019/12/25 09:55
 */
public interface DbToolsPort {
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
    Connection oracleGetConnection(String connectionMode, String address, String port, String dbName,
                                   String username, String password);

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
    Connection mysqlGetConnection(String address, String port, String username, String password,
                                  String dbName);

    /**
     * 回收Connection对象
     *
     * @param connection 数据库连接对象
     */
    void releaseConn(Connection connection);

    /**
     * 回收Connection和Statement对象
     *
     * @param connection 数据库连接对象
     * @param statement  数据库结果对象
     */
    void releaseConnAndStat(Connection connection, Statement statement);

    /**
     * 回收Connection、Statement和ResultSet对象
     *
     * @param connection 数据库连接对象
     * @param statement  数据库结果对象
     * @param resultSet  数据库结果集对象
     */
    void releaseConnAndStatAndRst(Connection connection, Statement statement, ResultSet resultSet);
}
