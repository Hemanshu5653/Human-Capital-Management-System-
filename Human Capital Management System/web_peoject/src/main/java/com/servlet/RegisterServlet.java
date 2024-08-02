package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entities.Employee;
import com.helper.EmployeeDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		List<Employee> list=new ArrayList();
		HttpSession session=req.getSession();
		PrintWriter out=res.getWriter();
		//String v1=req.getParameter("id");
		//int id=Integer.parseInt(v1);
		String name=req.getParameter("name");
		String v2=req.getParameter("sal");
		int sal=Integer.parseInt(v2);
		String dept=req.getParameter("dept");
		String skills=req.getParameter("skills");
		String pass=req.getParameter("pass");
		Employee emp=new Employee(name,sal,dept,skills,pass);
		EmployeeDAO ref=new EmployeeDAO();
		int count=ref.addEmployee(emp);
		if(count==0) {
			res.sendRedirect("employee.jsp");
		}
		else {
		list=EmployeeDAO.getAllEmp();
		session.setAttribute("myList", list);	
		res.sendRedirect("employee.jsp");
		}
	}

}
