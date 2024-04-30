package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.UpdateDao;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentName = request.getParameter("studentName");
        String fatherName = request.getParameter("fatherName");
        String motherName = request.getParameter("motherName");
        String studentGroup = request.getParameter("studentGroup");
        String studentSection = request.getParameter("studentSection");
        String studentPhoneNumber = request.getParameter("studentPhoneNumber");
        String parentPhoneNumber = request.getParameter("parentPhoneNumber");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UpdateDao updateDao = new UpdateDao();
        boolean updated = updateDao.updateStudentInfo(studentName, studentGroup, studentSection, studentPhoneNumber, fatherName, motherName, parentPhoneNumber, username, password, email);

        if (updated) {
            request.setAttribute("message", "Student information updated successfully");
        } else {
            request.setAttribute("message", "Failed to update student information");
        }

        request.getRequestDispatcher("/updateResult.jsp").forward(request, response);
    }
}
