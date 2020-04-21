package com.hwm.jdbc;

import com.hwm.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentJdbc {
    private JdbcConnection jdbcConnection;

    @Autowired
    public StudentJdbc(JdbcConnection jdbcConnection) {
        this.jdbcConnection = jdbcConnection;
    }

    public List<Student> selectAll() {
        List<Student> list = new ArrayList<>();

        final String sqlString = "SELECT * FROM student;";
        try (Connection connection = jdbcConnection.getHikariDataSource().getConnection()) {
            connection.setAutoCommit(false);
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    while (resultSet.next()) {
                        var student = new Student();
                        student.setId(resultSet.getInt("id"));
                        student.setName(resultSet.getString("name"));
                        student.setCreateTime(resultSet.getTimestamp("create_time"));
                        list.add(student);
                    }
                    connection.commit();
                }
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Student select(int studentId) {
        var student = new Student();

        final String sqlString = "SELECT * FROM student WHERE id = " + studentId;
        try (Connection connection = jdbcConnection.getHikariDataSource().getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
                try (ResultSet resultSet = preparedStatement.executeQuery(sqlString)) {
                    if (resultSet.next()) {
                        student.setId(resultSet.getInt("id"));
                        student.setName(resultSet.getString("name"));
                        student.setCreateTime(resultSet.getTimestamp("create_time"));
                        connection.commit();
                    } else {
                        connection.commit();
                        return null;
                    }
                }
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    public boolean addStudent(Student student) {
        final String sqlString = "INSERT INTO student (id, name) VALUES (?, ?);";
        try (Connection connection = jdbcConnection.getHikariDataSource().getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
                preparedStatement.setInt(1, student.getId());
                preparedStatement.setString(2, student.getName());
                preparedStatement.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
