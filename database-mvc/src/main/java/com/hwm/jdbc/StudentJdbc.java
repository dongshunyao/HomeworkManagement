package com.hwm.jdbc;

import com.hwm.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentJdbc {
    public static List<Student> selectAll() {
        List<Student> list = new ArrayList<>();

        final String sqlString = "SELECT * FROM student;";
        try (Connection connection = JdbcConnection.getInstance().getHikariDataSource().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    while (resultSet.next()) {
                        var student = new Student();
                        student.setId(resultSet.getInt("id"));
                        student.setName(resultSet.getString("name"));
                        student.setCreateTime(resultSet.getTimestamp("create_time"));
                        list.add(student);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static Student select(int studentId) {
        var student = new Student();

        final String sqlString = "SELECT * FROM student WHERE id = " + studentId;
        try (Connection connection = JdbcConnection.getInstance().getHikariDataSource().getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
                try (ResultSet resultSet = preparedStatement.executeQuery(sqlString)) {

                    if (resultSet.next()) {
                        student.setId(resultSet.getInt("id"));
                        student.setName(resultSet.getString("name"));
                        student.setCreateTime(resultSet.getTimestamp("create_time"));
                    } else {
                        return null;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    public static boolean addStudent(Student student) {
        final String sqlString = "INSERT INTO student (id, name) VALUES (?, ?);";
        try (Connection connection = JdbcConnection.getInstance().getHikariDataSource().getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
                preparedStatement.setInt(1, student.getId());
                preparedStatement.setString(2, student.getName());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
