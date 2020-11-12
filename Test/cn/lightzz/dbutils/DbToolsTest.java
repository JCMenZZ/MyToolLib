package cn.lightzz.dbutils;

import org.junit.jupiter.api.Test;

class DbToolsTest {

    @Test
    void oracleGetConnection() {
        new DbTools().oracleGetConnection("thin", "localhost", "1521", "XE",
                "system", "zhb1998");
    }

    @Test
    void mysqlGetConnection() {
        new DbTools().mysqlGetConnection("localhost", "3306", "root",
                "root", "demo");
    }

    @Test
    void releaseConn() {
        new DbTools().releaseConn(new DbTools().mysqlGetConnection("localhost", "3306",
                "root", "root", "demo"));
    }
}