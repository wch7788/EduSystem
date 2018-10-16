package com.capgemini.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.demo.bean.Student;
import com.capgemini.demo.mapper.StudentMapper;

@Repository("StudentService")
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentMapper studentmapper;
	

	@Override
	public boolean checkRegister(Student student) {
		//***************有可能要修改*************************
		//***************有可能要修改*************************
		//***************有可能要修改*************************
		//***************有可能要修改*************************
      if(student.getName()==""||student.getName()==null){ return false;}
      if(student.getEmail()==""||student.getEmail()==null){return false;}
      if(student.getPassword()==""||student.getPassword()==null){return false;}
		
		return true;
	}

	@Override
	public void addStudent(Student student) {
     	   studentmapper.addStudent(student);
	}

	@Override
	public int AutoID() {
		int id=studentmapper.CounStudent()+1;
		return id;
	}

	@Override
	public boolean checklogin(String name, String password) {
            if("".equals(name)||name==null){return false;}
            if("".equals(password)||password==null){return false;}
            Student student=studentmapper.FindByEmail(name);
		    if(student==null){return false;}
		    if(password.equals(student.getPassword())){
		    	return true;
		    	}else{
		    		return false;
		    	}
		
	}
          
}
