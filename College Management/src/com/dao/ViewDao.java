package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.Admin;

public class ViewDao {

    private String url = "jdbc:mysql://localhost:3306/krishna";
    private String user = "root";
    private String pwd = "krishna@1997";

    private static final String SELECT_ALL_STUDENTS = "Select * from Student";

    public ViewDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Admin> getAllStudents() {
        List<Admin> students = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, pwd);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS)) {
        	//preparedStatement.setString(1, uname);
        	ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Admin student = new Admin();
                student.setStudentName(resultSet.getString("student_name"));
                student.setStudentGroup(resultSet.getString("student_group"));
                student.setStudentSection(resultSet.getString("student_section"));
                student.setStudentPhoneNumber(resultSet.getString("student_phone_number"));
                student.setFatherName(resultSet.getString("father_name"));
                student.setMotherName(resultSet.getString("mother_name"));
                student.setParentPhoneNumber(resultSet.getString("parent_phone_number"));
                student.setUsername(resultSet.getString("username"));
                student.setPassword(resultSet.getString("password"));
                student.setEmail(resultSet.getString("email"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

}
