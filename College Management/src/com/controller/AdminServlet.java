package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		session.setAttribute("username", username);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/krishna", "root", "krishna@1997");

			// Query to retrieve username and password from Admin table
			PreparedStatement adminStatement = con
					.prepareStatement("SELECT * FROM Admin WHERE username=? AND password=?");
			adminStatement.setString(1, username);
			adminStatement.setString(2, password);
			ResultSet adminResult = adminStatement.executeQuery();
			// boolean i=adminResult.next();

			// Query to retrieve username and password from student table
			PreparedStatement studentStatement = con
					.prepareStatement("SELECT username, password FROM Student WHERE username=? AND password=?");
			studentStatement.setString(1, username);
			studentStatement.setString(2, password);
			ResultSet studentResult = studentStatement.executeQuery();
			// boolean j=studentResult.next();
			if (adminResult.next()) {
				// Admin username and password matched
				response.sendRedirect("Admin.html");
			} else if (studentResult.next()) {
				// Student username and password matched
				response.sendRedirect("Student.html");
			} else {
				// No match found, display error message
				request.getRequestDispatcher("AdminLogin.html").forward(request, response);
			}

			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(out);
		}
	}
}
