package com.hwm.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.stereotype.Component;

@Component
public class JdbcConnection {
    private HikariDataSource hikariDataSource;

    public JdbcConnection() {
        final String url = "jdbc:mysql://localhost:3306/hwm?serverTimezone=GMT%2B8";
        final String driverName = "com.mysql.cj.jdbc.Driver";

        var hikariConfig = new HikariConfig();
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("19990326");
        hikariConfig.setDriverClassName(driverName);
        hikariConfig.setJdbcUrl(url);
        hikariDataSource = new HikariDataSource(hikariConfig);

        hikariDataSource.setIdleTimeout(60000);
        hikariDataSource.setConnectionTimeout(60000);
        hikariDataSource.setValidationTimeout(3000);
        hikariDataSource.setMaxLifetime(60000);
        hikariDataSource.setMaximumPoolSize(10);
    }

    public HikariDataSource getHikariDataSource() {
        return hikariDataSource;
    }
}
