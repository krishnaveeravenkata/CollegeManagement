package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.StudentDao;
import com.model.Student;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("username");

		StudentDao studentDao = new StudentDao();

		List<Student> students = studentDao.getAllStudents(uname);

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Student Details</title>");
		out.println("<style>");
		out.println("/* Your CSS styles */");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Student Details</h1>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>Name</th>");
		out.println("<th>Father's Name</th>");
		out.println("<th>Mother's Name</th>");
		out.println("<th>Group</th>");
		out.println("<th>Section</th>");
		out.println("<th>Phone Number</th>");
		out.println("<th>Email</th>");
		out.println("<th>Username</th>");
		out.println("<th>Password</th>");
		out.println("</tr>");

		for (Student student : students) {
			out.println("<tr>");
			out.println("<td>" + student.getStudentName() + "</td>");
			out.println("<td>" + student.getFatherName() + "</td>");
			out.println("<td>" + student.getMotherName() + "</td>");
			out.println("<td>" + student.getStudentGroup() + "</td>");
			out.println("<td>" + student.getStudentSection() + "</td>");
			out.println("<td>" + student.getStudentPhoneNumber() + "</td>");
			out.println("<td>" + student.getEmail() + "</td>");
			out.println("<td>" + student.getUsername() + "</td>");
			out.println("<td>" + student.getPassword() + "</td>");
			out.println("</tr>");
		}

		out.println("</table>");
		out.println("<div class=\"back-button-container\">");
		out.println("<button class=\"back-button\" onclick=\"goBack()\">Back</button>");
		out.println("</div>");
		out.println("<script>");
		out.println("function goBack() {");
		out.println("  window.history.back();");
		out.println("}");
		out.println("</script>");
		out.println("</body>");
		out.println("</html>");

		out.close(); 
	}

}
