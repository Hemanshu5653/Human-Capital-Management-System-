<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.entities.Employee"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="employee.css">
</head>
<body>


	<%
	String type = (String) session.getAttribute("type");
	ArrayList<Employee> list = (ArrayList<Employee>) session.getAttribute("searchList");
	if (list.isEmpty()) {
	%>
	
	<h1>No Records Found!!</h1>
	<%
	} else {
	for (Employee emp : list) {
	%>
	<table style="margin-top: 100px">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Salary</th>
			<th>Department</th>
			<th>Skill set</th>
		</tr>
		<tr>
			<td><%=emp.getId()%></td>
			<td><%=emp.getName()%></td>
			<td><%=emp.getSal()%></td>
			<td><%=emp.getDepartment()%></td>
			<td><%=emp.getSkillSet()%></td>
		</tr>
		<%
		}
		}
		%>

	</table>
	<br>
	<br>
	<button class='button1' style="margin-left: 45%; font-size: 18px">
		<a href="login.jsp">Home</a>
	</button>

</body>
</html>