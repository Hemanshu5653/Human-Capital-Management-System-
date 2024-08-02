package com.entities;

public class EmployeeRecordClass {
	
	int id;
	String name;
	int sal;
	String skillset;
	String department;
	String time;
	
	public EmployeeRecordClass() {
		
	}
	public EmployeeRecordClass(int v1,String v2,int v3,String v4,String v5,String v6) {
		id=v1;
		name=v2;
		sal=v3;
		skillset=v4;
		department=v5;
		time=v6;
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
	public String getSkillset() {
		return skillset;
	}
	public void setSkillset(String skillset) {
		this.skillset = skillset;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
