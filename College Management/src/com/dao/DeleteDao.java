// DeleteDao.java

package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDao {
    private String url = "jdbc:mysql://localhost:3306/krishna";
    private String user = "root";
    private String pwd = "krishna@1997";

    // Load the MySQL JDBC driver
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException("Failed to load the JDBC driver.");
        }
    }

    // Method to delete student information
    public boolean deleteStudent(String username) {
        boolean deleted = false;
        try (Connection connection = DriverManager.getConnection(url, user, pwd)) {
            String query = "DELETE FROM Student WHERE username=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                deleted = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deleted;
    }
}
