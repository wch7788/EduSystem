package com.capgemini.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.capgemini.demo.bean.Student;

@Mapper
public interface StudentMapper {

	void addStudent(Student student);

	int CounStudent();
	public Student FindByEmail(String email);

}
