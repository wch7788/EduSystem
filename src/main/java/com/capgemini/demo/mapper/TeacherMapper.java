package com.capgemini.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.capgemini.demo.bean.Teacher;
@Mapper
public interface TeacherMapper {

	void addTeacher(Teacher teacher);

	int CountTeacher();
	public Teacher FindByEmail(String email);

}
