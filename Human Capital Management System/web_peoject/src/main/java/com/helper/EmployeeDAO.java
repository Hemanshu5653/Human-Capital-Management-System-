package com.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.connection.DBconnection;
import com.entities.Employee;
import com.entities.EmployeeRecordClass;

public class EmployeeDAO {

	public int addEmployee(Employee emp) {
		int updateRowCount=0;

		try {		
			
			Connection connection=DBconnection.getConnection();
			String query = "insert into employee(name,sal,department,skillset,password) values(?,?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, emp.getName());
			pstmt.setInt(2, emp.getSal());
			pstmt.setString(3, emp.getDepartment());
			pstmt.setString(4, emp.getSkillSet());
			pstmt.setString(5, emp.getPass());

			updateRowCount=pstmt.executeUpdate();
			connection.close();

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateRowCount;
		
		
	}

	public static Employee getEmpDetails(int id)  {

		Employee emp=null;
		try {
		Connection connection=DBconnection.getConnection();
		String query = "select * from employee where id=?";
		PreparedStatement pstmt=connection.prepareStatement(query);
		pstmt.setInt(1, id);
		ResultSet rs=pstmt.executeQuery();
		
		int id1 = 0,sal = 0;
		String name = null,dept = null,skill = null;
		while(rs.next()) {
		id1=rs.getInt(1);
		name=rs.getString(2);
		sal=rs.getInt(3);
		dept=rs.getString(4);
		skill=rs.getString(5);
		}
		System.out.println(id1);
		System.out.println(name);
		connection.close();
		emp=new Employee(id1,name,sal,dept,skill);
		return emp;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return emp;
	}

	
	public static List<Employee> getAllEmp() {
		
		List<Employee> list=new ArrayList();
		
		try {
			Connection connection=DBconnection.getConnection();
			String query = "select * from employee";
			PreparedStatement pstmt=connection.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			
			int id1 ,sal;
			String name,dept,skill;
			while(rs.next()) {
			id1=rs.getInt(1);
			name=rs.getString(2);
			sal=rs.getInt(3);
			dept=rs.getString(4);
			skill=rs.getString(5);
			Employee emp=new Employee(id1,name,sal,dept,skill);
			list.add(emp);
			}
			connection.close();
			return list;
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return list;		
	}

	public static int deleteEmployee(int id) {
		
//1.	First Adding this Data to Another table to Maintain Deleted Record
		Employee emp=EmployeeDAO.getEmpDetails(id);
		try {		
			Connection connection=DBconnection.getConnection();
			String query = "insert into record values(?,?,?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, emp.getId());
			pstmt.setString(2, emp.getName());
			pstmt.setInt(3, emp.getSal());
			pstmt.setString(4, emp.getSkillSet());
			pstmt.setString(5, emp.getDepartment());
			LocalDateTime s=LocalDateTime.now();
			String time=String.valueOf(s);
			System.out.println(s);
			pstmt.setString(6, time);

			pstmt.executeUpdate();
			connection.close();

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
//2.	Then Deleting The Data.		
		int updateRowCount=0;
		try {
			Connection connection=DBconnection.getConnection();
			String query = "delete from employee where id=?";
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.setInt(1, id);
			 pstmt.executeUpdate();
			 connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return updateRowCount;
			
		}

	public static int updateProfile(int id, String name, int salary, String dept, String skills) {
		
		int updateRowCount=0;
		try {		
			Connection connection=DBconnection.getConnection();
			String query = "update employee set name=?,department=?,skillset=? where id=?";
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2,dept);
			pstmt.setString(3,skills);
			pstmt.setInt(4, id);

			pstmt.executeUpdate();
			connection.close();

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateRowCount;
	}


	public static List<EmployeeRecordClass> getAllDeletedRecords() {
		
		List<EmployeeRecordClass> list=new ArrayList();
		
		try {
			Connection connection=DBconnection.getConnection();
			String query = "select * from record";
			PreparedStatement pstmt=connection.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			
			int id1 ,sal;
			String name,dept,skill,time;
			while(rs.next()) {
			id1=rs.getInt(1);
			name=rs.getString(2);
			sal=rs.getInt(3);
			skill=rs.getString(4);
			dept=rs.getString(5);
			time=rs.getString(6);
			EmployeeRecordClass emp=new EmployeeRecordClass(id1,name,sal,skill,dept,time);
			list.add(emp);
			}
			connection.close();
			return list;
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return list;		
	}

	
	

}
