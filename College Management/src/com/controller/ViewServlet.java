package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ViewDao;
import com.model.Admin;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			ViewDao viewDao = new ViewDao();

			List<Admin> students = viewDao.getAllStudents();

			response.setContentType("text/html");

			PrintWriter out = response.getWriter();

			// Write the HTML response
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>Student Details</title>");
			out.println("<style>");
			out.println("body {");
			out.println("  background-image: url('https://wallpaperaccess.com/full/1930779.jpg');");
			out.println("  background-size: cover;");
			out.println("  font-family: Arial, sans-serif;");
			out.println("  color: #333;"); // Text color
			out.println("  margin: 0;");
			out.println("  padding: 0;");
			out.println("}");
			out.println("table {");
			out.println("  width: 80%;"); // Adjust table width
			out.println("  margin: 50px auto;"); // Centering the table horizontally
			out.println("  border-collapse: collapse;");
			out.println("  background-color: rgba(255, 255, 255, 0.7);"); // Semi-transparent white background for
																			// better readability
			out.println("  border-radius: 10px;"); // Rounded corners
			out.println("  overflow: hidden;"); // Hide overflowing content
			out.println("  box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);"); // Adding a subtle shadow
			out.println("}");
			out.println("th, td {");
			out.println("  padding: 12px 15px;");
			out.println("  text-align: left;");
			out.println("  border-bottom: 1px solid #ddd;");
			out.println("}");
			out.println("th {");
			out.println("  background-color: #f2f2f2;");
			out.println("}");
			out.println("h1 {");
			out.println("  text-align: center;");
			out.println("  padding: 20px 0;");
			out.println("}");
			out.println(".back-button {"); // Style for the back button
			out.println("  display: block;");
			out.println("  width: 100px;");
			out.println("  margin: 20px auto 0;"); // Positioning at the top with auto margin for centering
			out.println("  padding: 10px;");
			out.println("  text-align: center;");
			out.println("  background-color: #4CAF50;");
			out.println("  color: white;");
			out.println("  border: none;");
			out.println("  border-radius: 5px;");
			out.println("  cursor: pointer;");
			out.println("}");
			out.println(".back-button-container {"); // Container for the back button
			out.println("  text-align: center;");
			out.println("  position: fixed;");
			out.println("  bottom: 20px;"); // Distance from the bottom
			out.println("  left: 0;");
			out.println("  right: 0;");
			out.println("}");
			out.println("</style>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Student Details</h1>");

			// Display student details in a table
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>Name</th>");
			out.println("<th>Father's Name</th>");
			out.println("<th>Mother's Name</th>");
			out.println("<th>Group</th>");
			out.println("<th>Section</th>");
			out.println("<th>Phone Number</th>");
			out.println("<th>Parent Phone Number</th>");
			out.println("<th>Email</th>");
			out.println("<th>Username</th>");
			out.println("<th>Password</th>");
			out.println("<th>Update</th>");
			out.println("<th>Delete</th>");
			out.println("</tr>");

			for (Admin student : students) {
				out.println("<tr>");
				out.println("<td>" + student.getStudentName() + "</td>");
				out.println("<td>" + student.getFatherName() + "</td>");
				out.println("<td>" + student.getMotherName() + "</td>");
				out.println("<td>" + student.getStudentGroup() + "</td>");
				out.println("<td>" + student.getStudentSection() + "</td>");
				out.println("<td>" + student.getStudentPhoneNumber() + "</td>");
				out.println("<td>" + student.getParentPhoneNumber() + "</td>");
				out.println("<td>" + student.getEmail() + "</td>");
				out.println("<td>" + student.getUsername() + "</td>");
				out.println("<td>" + student.getPassword() + "</td>");
				// Pass student details to UpdateServlet when the "Update" button is clicked
				out.println("<td><a href=\"UpdateServlet?studentName=" + student.getStudentName() + "&fatherName="
						+ student.getFatherName() + "&motherName=" + student.getMotherName() + "&studentGroup="
						+ student.getStudentGroup() + "&studentSection=" + student.getStudentSection()
						+ "&studentPhoneNumber=" + student.getStudentPhoneNumber() + "&parentPhoneNumber="
						+ student.getParentPhoneNumber() + "&email=" + student.getEmail() + "&username="
						+ student.getUsername() + "&password=" + student.getPassword() + "\">Update</a></td>");
				// Delete button with JavaScript function call
				out.println(
						"<td><button onclick=\"deleteStudent('" + student.getUsername() + "')\">Delete</button></td>");
				out.println("</tr>");
			}

			out.println("</table>");

			// JavaScript function for deletion
			out.println("<script>");
			out.println("function deleteStudent(username) {");
			out.println("    if (confirm(\"Are you sure you want to delete this student?\")) {");
			out.println("        var xhr = new XMLHttpRequest();");
			out.println("        xhr.onreadystatechange = function() {");
			out.println("            if (xhr.readyState == XMLHttpRequest.DONE) {");
			out.println("                if (xhr.status == 200) {");
			out.println("                    // Reload the page to reflect the changes");
			out.println("                    window.location.reload();");
			out.println("                } else {");
			out.println("                    // Handle error");
			out.println("                    alert(\"Failed to delete student\");");
			out.println("                }");
			out.println("            }");
			out.println("        };");
			out.println("        xhr.open(\"POST\", \"DeleteServlet\", true);");
			out.println("        xhr.setRequestHeader(\"Content-Type\", \"application/x-www-form-urlencoded\");");
			out.println("        xhr.send(\"username=\" + username);");
			out.println("    }");
			out.println("}");
			out.println("</script>");

			// Adding back button
			out.println("<div class=\"back-button-container\">");
			out.println("<button class=\"back-button\" onclick=\"goBack()\">Back</button>");
			out.println("</div>");

			out.println("<script>");
			out.println("function goBack() {");
			out.println("  window.history.back();"); // JavaScript function to navigate back
			out.println("}");
			out.println("</script>");

			out.println("</body>");
			out.println("</html>");
		} catch (IOException e) {
			e.printStackTrace(); // Or handle the exception appropriately
		}
	}

}
