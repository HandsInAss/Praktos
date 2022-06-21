package com.jdbc;

import java.sql.*;

public final class JdbcUtils {
    private static String url = "jdbc:mysql://localhost:3306/airport?useSSL=false";
    private static String user = "root";
    private static String password = "11235813";
    private JdbcUtils() {
    }
    static {    // Статический код код, загрузите драйвер JDBC один раз
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    // выпустить ресурс для суждения
    public static void free(ResultSet rs, Statement ps, Connection conn) {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (conn != null)
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
            }
        }
    }
}