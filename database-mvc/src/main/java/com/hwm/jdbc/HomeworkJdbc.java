package com.hwm.jdbc;

import com.hwm.model.Homework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class HomeworkJdbc {
    private JdbcConnection jdbcConnection;

    @Autowired
    public HomeworkJdbc(JdbcConnection jdbcConnection) {
        this.jdbcConnection = jdbcConnection;
    }

    public List<Homework> selectAll() {
        var list = new ArrayList<Homework>();

        final String sqlString = "SELECT * FROM homework;";
        try (Connection connection = jdbcConnection.getHikariDataSource().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    while (resultSet.next()) {
                        var homework = new Homework();
                        homework.setId(resultSet.getInt("id"));
                        homework.setTitle(resultSet.getString("title"));
                        homework.setContent(resultSet.getString("content"));
                        homework.setCreateTime(resultSet.getTimestamp("create_time"));
                        list.add(homework);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Homework select(int homeworkId) {
        var homework = new Homework();

        final String sqlString = "SELECT * FROM homework WHERE id = " + homeworkId;
        try (Connection connection = jdbcConnection.getHikariDataSource().getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
                try (ResultSet resultSet = preparedStatement.executeQuery(sqlString)) {
                    while (resultSet.next()) {
                        homework.setId(resultSet.getInt("id"));
                        homework.setTitle(resultSet.getString("title"));
                        homework.setContent(resultSet.getString("content"));
                        homework.setCreateTime(resultSet.getTimestamp("create_time"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return homework;
    }

    public boolean addHomework(Homework homework) {
        final String sqlString = "INSERT INTO homework (title, content) VALUES (?, ?);";
        try (Connection connection = jdbcConnection.getHikariDataSource().getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
                preparedStatement.setString(1, homework.getTitle());
                preparedStatement.setString(2, homework.getContent());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
