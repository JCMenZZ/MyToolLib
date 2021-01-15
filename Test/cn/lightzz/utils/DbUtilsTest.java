package cn.lightzz.utils;

import org.junit.Test;

import java.sql.*;

public class DbUtilsTest {

    @Test
    public void oracleGetConnection() {
        Connection conn = DbUtils.oracleGetConnection("thin", "localhost", "1521", "XE",
                "system", "system");
        System.out.println(conn);
    }

    @Test
    public void mysqlGetConnection() {
        Connection conn = DbUtils.mysqlGetConnection("localhost", "3306", "root",
                "root", "test");
        System.out.println(conn);
    }

    @Test
    public void release() {
        Connection conn = DbUtils.oracleGetConnection("thin", "localhost", "1521", "XE",
                "system", "system");
        DbUtils.release(conn);
    }

    @Test
    public void releaseConnAndStat() throws SQLException {
        Connection conn = DbUtils.mysqlGetConnection("localhost", "3306", "root",
                "root", "test");
        Statement statement = conn.createStatement();
        DbUtils.release(conn, statement);
    }

    @Test
    public void releaseConnAndStatAndRst() throws SQLException {
        Connection conn = DbUtils.mysqlGetConnection("localhost", "3306", "root",
                "root", "test");
        PreparedStatement pst = conn.prepareStatement("select * from user");
        ResultSet rst = pst.executeQuery();
        while (rst.next()) {
            System.out.println(rst.getString("username"));
        }
        DbUtils.release(conn, pst, rst);
    }
}