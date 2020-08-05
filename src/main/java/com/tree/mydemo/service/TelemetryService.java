package com.tree.mydemo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public interface TelemetryService {

    String dirverName = "org.apache.hive.jdbc.HiveDriver";
    String url = "jdbc:hive2://10.20.200.183:10000";

    static Connection getConn(){

        Connection conn = null;
        try {
            Class.forName(dirverName);
            conn = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    static Statement getStmt(Connection conn){

        try {
            return conn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    static void closeConn(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void closeStmt(Statement stmt){
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
