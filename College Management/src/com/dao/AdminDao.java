package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/krishna";
    private String jdbcUsername = "root";
    private String jdbcPassword = "krishna@1997";

    private static final String SELECT_ADMIN_SQL = "SELECT * FROM Admin WHERE username = ? AND password = ?";
    private static final String SELECT_STUDENT_SQL = "SELECT * FROM Student WHERE username = ? AND password = ?";

    public AdminDao() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public boolean isAdmin(String username, String password) {
        boolean isAdmin = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADMIN_SQL)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                isAdmin = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdmin;
    }

    public boolean isStudent(String username, String password) {
        boolean isStudent = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_SQL)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                isStudent = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isStudent;
    }
}
