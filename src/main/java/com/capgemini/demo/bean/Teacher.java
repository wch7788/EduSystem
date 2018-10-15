package com.capgemini.demo.bean;

public class Teacher {
     private int id;
     private String name;
     private String password;
     private String email;
     private int courseid;
     
     
	public Teacher() {
		super();
	}
	public Teacher(int id, String name, String password, String email, int courseid) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.courseid = courseid;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
     
     
     
     
}
