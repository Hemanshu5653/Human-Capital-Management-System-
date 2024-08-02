package com.entities;

public class Employee {

	int id;
	String name;
	int sal;
	String department;
	String skillSet;
	String pass;
	
	public Employee() {
		
	}
	
	public Employee(int v1, String v2, int v3,String v4,String v5,String v6) {
		id=v1;
		name=v2;
		sal=v3;
		department=v4;
		skillSet=v5;
		pass=v6;
		
	}

	public Employee(int id2, String name2, int sal2, String dept, String skill) {
		
		id=id2;
		name=name2;
		sal=sal2;
		department=dept;
		skillSet=skill;
		
	}

	public Employee(String name2, int sal2, String dept, String skills, String pass2) {
		
		name=name2;
		sal=sal2;
		department=dept;
		skillSet=skills;
		pass=pass2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}


