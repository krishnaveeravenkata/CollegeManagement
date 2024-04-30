package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegistrationDao {
    public boolean checkRegistration(String studentName, String studentGroup, String studentSection,
            String studentPhoneNumber, String fatherName, String motherName, String parentPhoneNumber, String username,
            String password, String email) {
        boolean isSuccess = false;
        try {
            Connection con = null;
            PreparedStatement pstmt = null;

            String query = "INSERT INTO Student (student_name, student_group, student_section, student_phone_number, father_name, mother_name, parent_phone_number, username, password, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            String url = "jdbc:mysql://localhost:3306/krishna";
            String user = "root";
            String pwd = "krishna@1997";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pwd);
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, studentName);
            pstmt.setString(2, studentGroup);
            pstmt.setString(3, studentSection);
            pstmt.setString(4, studentPhoneNumber);
            pstmt.setString(5, fatherName);
            pstmt.setString(6, motherName);
            pstmt.setString(7, parentPhoneNumber);
            pstmt.setString(8, username);
            pstmt.setString(9, password);
            pstmt.setString(10, email);

            int rowsInserted = pstmt.executeUpdate();
            isSuccess = rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
