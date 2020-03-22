package com.hwm.jdbc;

import java.sql.*;

public class JdbcConnection {
    private static JdbcConnection jdbcConnection;
    private Connection connection;

    public static JdbcConnection getInstance() {
        if (jdbcConnection == null) {
            jdbcConnection = new JdbcConnection();
        }
        return jdbcConnection;
    }

    private JdbcConnection() {
        final String url = "jdbc:mysql://localhost:3306/hwm?serverTimezone=GMT%2B8";
        final String driverName = "com.mysql.cj.jdbc.Driver";
        // 这里使用的是 mysql-connector-java-8.0.19.jar
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, "root", "19990326");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
