package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Employee;
import com.helper.EmployeeDAO;
import com.helper.Validate;

@WebServlet(name="emp", value="/emp")
public class EmpUpdateByHR extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		PrintWriter out =res.getWriter();
		
		String id1=req.getParameter("id");
		int id=Integer.parseInt(id1);
		boolean valid=Validate.isValid(id);
		
		
		if(valid) {
			
			Employee emp=new Employee();
			emp=EmployeeDAO.getEmpDetails(id);
			out.println("<html>");
			out.println("<head></head>");
			out.println("<body>");
			out.println("<h2>You Can Update Here.</h2>");
			out.println("<form action='acceptUpdation' method='post'>");
			out.println("<input type='text' name='id' value="+emp.getId()+" readonly> ID <br><br>");
			out.println("<input type='text' name='name' value="+emp.getName()+"> Name <br><br>");
			out.println("<input type='text' name='sal' value="+emp.getSal()+" readonly>Salary<br><br>");	
			out.println("<input type='text' name='dept' value="+emp.getDepartment()+">	Department<br><br>");
			out.println("<input type='text' name='skills' value="+emp.getSkillSet()+">Skillsets	<br><br>");
			out.println("<input type='submit'>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}
		
		else {
			res.sendRedirect("empUpdateByHR.jsp");

		}
	}
}


