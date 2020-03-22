package com.hwm.jdbc;

import com.hwm.model.Homework;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HomeworkJdbc {
    public static List<Homework> selectAll() {
        var list = new ArrayList<Homework>();

        final String sqlString = "SELECT * FROM homework;";
        try (Statement statement = JdbcConnection.getInstance().getConnection().createStatement()) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static Homework select(int homeworkId) {
        var homework = new Homework();

        final String sqlString = "SELECT * FROM homework WHERE id = " + homeworkId;
        try (PreparedStatement preparedStatement = JdbcConnection.getInstance().getConnection().prepareStatement(sqlString)) {
            try (ResultSet resultSet = preparedStatement.executeQuery(sqlString)) {
                while (resultSet.next()) {
                    homework.setId(resultSet.getInt("id"));
                    homework.setTitle(resultSet.getString("title"));
                    homework.setContent(resultSet.getString("content"));
                    homework.setCreateTime(resultSet.getTimestamp("create_time"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return homework;
    }

    public static boolean addHomework(Homework homework) {
        final String sqlString = "INSERT INTO homework (title, content) VALUES (?, ?);";
        try (PreparedStatement preparedStatement = JdbcConnection.getInstance().getConnection().prepareStatement(sqlString)) {
            preparedStatement.setString(1, homework.getTitle());
            preparedStatement.setString(2, homework.getContent());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
