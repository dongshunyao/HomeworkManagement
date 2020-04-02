package com.hwm.jdbc;

import com.hwm.model.SubmitHomework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class SubmitHomeworkJdbc {
    private JdbcConnection jdbcConnection;

    @Autowired
    public SubmitHomeworkJdbc(JdbcConnection jdbcConnection) {
        this.jdbcConnection = jdbcConnection;
    }

    public List<SubmitHomework> select(int homeworkId) {
        var list = new ArrayList<SubmitHomework>();

        final String sqlString = "SELECT * FROM submit_homework WHERE homework_id = " + homeworkId;
        try (Connection connection = jdbcConnection.getHikariDataSource().getConnection()) {
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

    public boolean addSubmitHomework(SubmitHomework submitHomework) {
        final String sqlString = "INSERT INTO submit_homework (student_id, homework_id, homework_title, homework_content) VALUES (?, ?, ?, ?);";
        try (Connection connection = jdbcConnection.getHikariDataSource().getConnection()) {
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
