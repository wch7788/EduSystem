package com.capgemini.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.capgemini.demo.bean.Course;

@Mapper
public interface CouserMapper {
	
	public List<Course> FinAllCourse();
    public Course FindByName(String name);
    public Course FindByID(int id);
}
