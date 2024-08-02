<%@page import="com.entities.Employee"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel='stylesheet' href='employee.css'>
</head>
<body>
	<br>
	<br>
	<h1 style="text-align:center">Employee Details</h1>
	<br>
	<br>
	<form action="search" method="post">
		<div style="margin-bottom: 30px; margin-left: 60%;">
			<input type="search" id="mySearch" name="id"
				placeholder="Enter Id..." style="height: 35px; width: 250px;" />
			<button style="height: 35px; width: 100px;">Search</button>
		</div>
	</form>
	<table>
		<tr >
			<th>ID</th>
			<th>Name</th>
			<th>Salary</th>
			<th>Department</th>
			<th>Skill set</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<%
		String type = (String) session.getAttribute("type");
		ArrayList<Employee> list = (ArrayList<Employee>) session.getAttribute("myList");
		if (list.isEmpty()) {
			out.println("<h3 Style='margin-left:60%'>No Records Found<h3>");
		} else {
			if (type.equals("HR")) {
				for (Employee emp : list) {
			out.println("<tr>");
			out.println("<td>" + emp.getId() + "</td>");
			out.println("<td>" + emp.getName() + "</td>");
			out.println("<td>" + emp.getSal() + "</td>");
			out.println("<td>" + emp.getDepartment() + "</td>");
			out.println("<td>" + emp.getSkillSet() + "</td>");
			out.println("<td><button class='button2'><a href='emp?id=" + emp.getId() + "'>" 
					+ "Edit</button></td>"+"</a>");
			out.println("<td><button class='button'><a href='deleteEmpByHRServlet?id=" + emp.getId() + "'>"
					+ "Delete</button></td>"+"</a>");
			out.println("</tr>");
				}

			} else {
				int id = (Integer) session.getAttribute("id");
				for (Employee emp : list) {
			out.println("<tr style='font-size:25px'>");
			out.println("<td >" + emp.getId() + "</td>");
			out.println("<td>" + emp.getName() + "</td>");
			out.println("<td>" + emp.getSal() + "</td>");
			out.println("<td>" + emp.getDepartment() + "</td>");
			out.println("<td>" + emp.getSkillSet() + "</td>");
			if (id == emp.getId()) {
				out.println(
						"<td><button class='button2'><a href='emp?id=" + emp.getId() + "'>Edit</button></td>" + "</a>");
			} else {
				out.println("<td></td>");
			}

			out.println("<td></td>");
			out.println("</tr>");
				}
			}
		}
		%>
	</table>
	<br>
	<br>
	<%	if (type.equals("HR")) {%>

	<button class='button1' style="margin-left: 30%;">
		<a href="Register.html">Register a New Employee</a>
	</button>

	<button class='button1' style="margin-left: 5%";>
		<a href="deletedRecords.jsp">View Deleted Records</a>
	</button>
	
<%} %>

</body>
</html>