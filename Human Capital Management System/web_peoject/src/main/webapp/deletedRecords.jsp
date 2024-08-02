<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="com.entities.EmployeeRecordClass"%>
    <%@page import="com.helper.EmployeeDAO"%>
    
    
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
	<h1 style="text-align: center">Deleted Records</h1>
<br>
<br>
	<table>
		<tr style='font-size: 25px'>
			<th>ID</th>
			<th>Name</th>
			<th>Salary</th>
			<th>Skill set</th>
			<th>Department</th>
			<th>Date & Time</th>
		</tr>

		<%

		ArrayList<EmployeeRecordClass> list;
		list=(ArrayList<EmployeeRecordClass>)EmployeeDAO.getAllDeletedRecords();
		if(list.isEmpty()){
			out.println("<h3 Style='margin-left:60%'>No Records Found<h3>");
		}
		else{
			for (EmployeeRecordClass emp : list) {
				out.println("<tr style='font-size:80px'>");
				out.println("<td>" + emp.getId() + "</td>");
				out.println("<td>" + emp.getName() + "</td>");
				out.println("<td>" + emp.getSal() + "</td>");
				out.println("<td>" + emp.getSkillset() + "</td>");
				out.println("<td>" + emp.getDepartment() + "</td>");
				out.println("<td>" + emp.getTime() + "</td>");
				out.println("</tr>");
			}	
		}
		
		%>
	</table>
</body>
</html>