package com.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connection.DBconnection;

public class Validate {

	public static boolean isValid(int id1, String pass1){
		int id = 0;
		String pass = null;
		try {
			Connection connection=DBconnection.getConnection();
			String query="select * from employee where id=?";
			PreparedStatement stmt=connection.prepareStatement(query);
			stmt.setInt(1, id1);
			ResultSet rs= stmt.executeQuery();
			
			while(rs.next()) {
			 id=rs.getInt(1);
			 pass=rs.getString(6);
			}
			 connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(id1==id && pass1.equals(pass) ) {
			
			return true;
			
		}
		
		return false;
		
	}

	
	public static boolean isValidHR(int id1, String pass1) {
	
		int id = 0;
		String pass = null;
		try {
			Connection connection=DBconnection.getConnection();
			String query="select * from hr where id=?";
			PreparedStatement stmt=connection.prepareStatement(query);
			stmt.setInt(1, id1);
			ResultSet rs= stmt.executeQuery();
			
			while(rs.next()) {
			 id=rs.getInt(1);
			 pass=rs.getString(3);
			}
			 connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(id1==id && pass1.equals(pass) ) {
			
			return true;
			
		}
		
		return false;
	}


	public static boolean isValid(int id1) {

		int id = 0;
		try {
			Connection connection=DBconnection.getConnection();
			String query="select * from employee where id=?";
			PreparedStatement stmt=connection.prepareStatement(query);
			stmt.setInt(1, id1);
			ResultSet rs= stmt.executeQuery();
			
			while(rs.next()) {
			 id=rs.getInt(1);
			}
			 connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(id==id1 ) {
			
			return true;
			
		}
		
		return false;
	}

	
}
