package com.capgemini.demo.service;

import com.capgemini.demo.bean.Head;
import com.capgemini.demo.bean.Teacher;

public interface TeacherService {

	boolean checkRegister(Teacher teacher);

	void addTeacher(Teacher teacher);

	int AutoID();
	
	boolean checklogin(String name, String password);

}
