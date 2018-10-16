package com.capgemini.demo.service;

import com.capgemini.demo.bean.Student;

public interface StudentService {

	boolean checkRegister(Student student);

	void addStudent(Student student);

	int AutoID();

	boolean checklogin(String name, String password);

}
