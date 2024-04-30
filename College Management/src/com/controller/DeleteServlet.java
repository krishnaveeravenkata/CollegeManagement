package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.DeleteDao;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");

		DeleteDao deleteDao = new DeleteDao();
		boolean deleted = deleteDao.deleteStudent(username);

		if (deleted) {
			response.getWriter().println("Student deleted successfully");
		} else {
			response.getWriter().println("Failed to delete student");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Handle GET requests here
		response.sendRedirect("ViewServlet"); // Redirect to an error page
	}
}
