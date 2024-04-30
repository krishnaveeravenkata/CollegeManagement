// UpdateDao.java
package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDao {
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

    // Method to update student information
    public boolean updateStudentInfo(String studentName, String studentGroup, String studentSection, String studentPhoneNumber, String fatherName, String motherName, String parentPhoneNumber, String username, String password, String email) {
        boolean updated = false;
        try (Connection connection = DriverManager.getConnection(url, user, pwd)) {
            String query = "UPDATE Student SET student_name=?, student_group=?, student_section=?, student_phone_number=?, father_name=?, mother_name=?, parent_phone_number=?, password=?, email=? WHERE username=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, studentName);
                statement.setString(2, studentGroup);
                statement.setString(3, studentSection);
                statement.setString(4, studentPhoneNumber);
                statement.setString(5, fatherName);
                statement.setString(6, motherName);
                statement.setString(7, parentPhoneNumber);
                statement.setString(8, password);
                statement.setString(9, email);
                statement.setString(10, username); // for WHERE clause
                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    updated = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // You should handle this exception properly, maybe log it or throw a custom exception
        }
        return updated;
    }
}
