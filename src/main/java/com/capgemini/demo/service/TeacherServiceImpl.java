package com.capgemini.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.demo.bean.Student;
import com.capgemini.demo.bean.Teacher;
import com.capgemini.demo.mapper.TeacherMapper;

@Repository("TeacherService")
public class TeacherServiceImpl implements TeacherService{
	@Autowired
	private TeacherMapper teachermapper;

	@Override
	public boolean checkRegister(Teacher teacher) {
		 if(teacher.getName()==""||teacher.getName()==null){ return false;}
	      if(teacher.getEmail()==""||teacher.getEmail()==null){return false;}
	      if(teacher.getPassword()==""||teacher.getPassword()==null){return false;}
			
			return true;
	}

	@Override
	public void addTeacher(Teacher teacher) {
          teachermapper.addTeacher(teacher);    
		
	}

	@Override
	public int AutoID() {
	   
		int id=teachermapper.CountTeacher()+1;
		return id;
	}

	@Override
	public boolean checklogin(String name, String password) {
		  if("".equals(name)||name==null){return false;}
          if("".equals(password)||password==null){return false;}
          Teacher teacher=teachermapper.FindByEmail(name);
		    if(teacher==null){return false;}
		    if(password.equals(teacher.getPassword())){
		    	return true;
		    	}else{
		    		return false;
		    	}
	}

}
