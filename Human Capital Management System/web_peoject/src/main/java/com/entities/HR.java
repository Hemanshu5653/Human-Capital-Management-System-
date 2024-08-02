package com.entities;

public class HR {

	int id;
	String name;
	String pwd;
	
	public HR(){
		
	}
	public HR(int v1,String v2,String pw) {
		id=v1;
		name=v2;
		pwd=pw;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
