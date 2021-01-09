package cn.lightzz.dbutils;


import org.junit.Test;

public class DbToolsTest {

    @Test
    public void oracleGetConnection() {
        new DbTools().oracleGetConnection("thin", "localhost", "1521", "XE",
                "system", "system");
    }

    @Test
    public void mysqlGetConnection() {
        new DbTools().mysqlGetConnection("localhost", "3306", "root",
                "root", "test");
    }

    @Test
    public void releaseConn() {
        new DbTools().releaseConn(new DbTools().mysqlGetConnection("localhost", "3306",
                "root", "root", "test"));
    }
}