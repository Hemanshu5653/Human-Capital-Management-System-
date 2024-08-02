package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.EmployeeDAO;

/**
 * Servlet implementation class AcceptUpdation
 */
@WebServlet("/acceptUpdation")
public class AcceptUpdation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptUpdation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter out=res.getWriter();
		
		String id1=req.getParameter("id");
		String name=req.getParameter("name");
		String sal=req.getParameter("sal");
		String dept=req.getParameter("dept");
		String skills=req.getParameter("skills");
		int salary=Integer.parseInt(sal);
		int id=Integer.parseInt(id1);
		int count=EmployeeDAO.updateProfile(id,name,salary,dept,skills);
		if(count==0) {
			out.println("Updated SuccessFully");
		}
		else
			out.println("Not Updated");
			
		
	
	
	}

}
