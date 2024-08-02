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
import com.helper.Validate;

/**
 * Servlet implementation class Loginservlet1
 */
@WebServlet("/login")
public class Loginservlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter out = res.getWriter();
		HttpSession session=req.getSession();

		boolean valid = false;
		String s = req.getParameter("id");
		int id = Integer.parseInt(s);
		String pass = req.getParameter("pwd");
		String radio = req.getParameter("radio");

//---------------------------------HR------------------------------------------//

		if (radio.equalsIgnoreCase("HR")) {

			valid = Validate.isValidHR(id, pass);
			if (valid) {
				// res.sendRedirect("hr.jsp");
				List<Employee> list = new ArrayList();
				list = EmployeeDAO.getAllEmp();
				
				session.setAttribute("type", radio);
				session.setAttribute("myList", list);
			//	req.getRequestDispatcher("employee.jsp").forward(req, res);
				res.sendRedirect("employee.jsp");


			} else {

				res.sendRedirect("login.jsp?error='Wrong id or password.'");
			}

		}

//---------------------------Employee--------------------------------------//

		else {
			valid = Validate.isValid(id, pass);

			if (valid == true) {
				List<Employee> list = new ArrayList();
				list = EmployeeDAO.getAllEmp();
				
				session.setAttribute("type", radio);
				session.setAttribute("myList", list);
				session.setAttribute("id", id);
				//req.getRequestDispatcher("employee.jsp").forward(req, res);
				res.sendRedirect("employee.jsp");
				
			} else {
				res.sendRedirect("login.jsp");
			}

		}
	}

}
