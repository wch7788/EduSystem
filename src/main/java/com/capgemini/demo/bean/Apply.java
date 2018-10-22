package com.capgemini.demo.bean;

import java.sql.Date;

public class Apply {
	private int id;
	private String studentname;
	private int courseid;
	private int teacherid;
	private int headid;
	private String email;
	private  String studentid;
	private String phone;
	private Date date;
	private int state;
	private int headstate;
	private int teacherstate;
	private Course course;
	private Teacher teacher;
	private Head head;
	
	public Apply(int id, String studentname, int courseid, int teacherid, int headid, String email, String studentid,String phone,
			Date date, int state, int headstate, int teacherstate) {
		super();
		this.id = id;
		this.studentname = studentname;
		this.courseid = courseid;
		this.teacherid = teacherid;
		this.headid = headid;
		this.email = email;
		this.studentid = studentid;
		this.phone=phone;
		this.date = date;
		this.state = state;
		this.headstate = headstate;
		this.teacherstate = teacherstate;
	}
	public Apply() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	public int getHeadid() {
		return headid;
	}
	public void setHeadid(int headid) {
		this.headid = headid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getHeadstate() {
		return headstate;
	}
	public void setHeadstate(int headstate) {
		this.headstate = headstate;
	}
	public int getTeacherstate() {
		return teacherstate;
	}
	public void setTeacherstate(int teacherstate) {
		this.teacherstate = teacherstate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Head getHead() {
		return head;
	}
	public void setHead(Head head) {
		this.head = head;
	}
	
	
	
	
	
	

}
