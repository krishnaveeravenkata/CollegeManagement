package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.RegistrationDao;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RegistrationDao rd = new RegistrationDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward GET requests to your registration form
        request.getRequestDispatcher("/registrationForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String studentName = request.getParameter("studentName");
        String studentGroup = request.getParameter("studentGroup");
        String studentSection = request.getParameter("studentSection");
        String studentPhoneNumber = request.getParameter("studentPhoneNumber");
        String fatherName = request.getParameter("fatherName");
        String motherName = request.getParameter("motherName");
        String parentPhoneNumber = request.getParameter("parentPhoneNumber");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        boolean isSuccess = rd.checkRegistration(studentName, studentGroup, studentSection, studentPhoneNumber,
                fatherName, motherName, parentPhoneNumber, username, password, email);

        if (isSuccess) {
            response.getWriter().write("Registration successful!");
        } else {
            response.getWriter().write("Registration failed. Please try again.");
        }
    }
}
