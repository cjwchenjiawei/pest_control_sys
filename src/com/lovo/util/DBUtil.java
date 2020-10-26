package com.lovo.util;

import java.sql.*;

public class DBUtil {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/pest_control_sys?useUnicode=true&characterEncoding=UTF8&useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String PWD = "123456";
    static{
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PWD);
        return connection;
    }

    public static void close(ResultSet rs, Statement ps, Connection conn){
        try {
            if(rs != null )rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(ps != null )ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn != null )conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
