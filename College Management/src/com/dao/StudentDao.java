package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;

public class StudentDao {

    // Database connection parameters
    private String jdbcURL = "jdbc:mysql://localhost:3306/krishna";
    private String jdbcUsername = "root";
    private String jdbcPassword = "krishna@1997";

    // SQL queries
    private static final String SELECT_ALL_STUDENTS = "SELECT student_name, student_group, student_section, student_phone_number, father_name, mother_name, username, password, email FROM Student where username=?";

    // Establish database connection
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<Student> getAllStudents(String username) {
        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Student s = new Student();
                String studentName = rs.getString("student_name");
                String fatherName = rs.getString("father_name");
                String motherName = rs.getString("mother_name");
                String studentGroup = rs.getString("student_group");
                String studentSection = rs.getString("student_section");
                String studentPhoneNumber = rs.getString("student_phone_number");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String username1 = rs.getString("username");
                s.setStudentName(studentName);
                s.setFatherName(fatherName);
                s.setMotherName(motherName);
                s.setStudentGroup(studentGroup);
                s.setStudentSection(studentSection);
                s.setStudentPhoneNumber(studentPhoneNumber);
                s.setEmail(email);
                s.setUsername(username1);
                s.setPassword(password);
                students.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
