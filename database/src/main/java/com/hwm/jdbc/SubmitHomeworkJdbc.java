package com.hwm.jdbc;

import com.hwm.model.SubmitHomework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubmitHomeworkJdbc {
    public static List<SubmitHomework> select(int homeworkId) {
        var list = new ArrayList<SubmitHomework>();

        final String sqlString = "SELECT * FROM submit_homework WHERE homework_id = " + homeworkId;
        try (Connection connection = JdbcConnection.getInstance().getHikariDataSource().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    while (resultSet.next()) {
                        var submitHomework = new SubmitHomework();
                        submitHomework.setId(resultSet.getInt("id"));
                        submitHomework.setStudentId(resultSet.getInt("student_id"));
                        submitHomework.setHomeworkId(resultSet.getInt("homework_id"));
                        submitHomework.setHomeworkTitle(resultSet.getString("homework_title"));
                        submitHomework.setHomeworkContent(resultSet.getString("homework_content"));
                        submitHomework.setCreateTime(resultSet.getTimestamp("create_time"));
                        list.add(submitHomework);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static boolean addSubmitHomework(SubmitHomework submitHomework) {
        if (StudentJdbc.select(submitHomework.getStudentId()) == null) {
            return false;
        }

        final String sqlString = "INSERT INTO submit_homework (student_id, homework_id, homework_title, homework_content) VALUES (?, ?, ?, ?);";
        try (Connection connection = JdbcConnection.getInstance().getHikariDataSource().getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
                preparedStatement.setInt(1, submitHomework.getStudentId());
                preparedStatement.setInt(2, submitHomework.getHomeworkId());
                preparedStatement.setString(3, submitHomework.getHomeworkTitle());
                preparedStatement.setString(4, submitHomework.getHomeworkContent());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
