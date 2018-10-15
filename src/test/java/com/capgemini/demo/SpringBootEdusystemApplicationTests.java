package com.capgemini.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.demo.bean.Head;
import com.capgemini.demo.bean.Student;
import com.capgemini.demo.bean.Teacher;
import com.capgemini.demo.mapper.HeadMapper;
import com.capgemini.demo.mapper.StudentMapper;
import com.capgemini.demo.mapper.TeacherMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootEdusystemApplicationTests {
	
	@Autowired
	StudentMapper studentmapper;
	@Autowired
	HeadMapper headmapper;
	@Autowired
	TeacherMapper teachermapper;

	@Test
	public void contextLoads() {
		this.test();
	}

	public void test(){
		/*Teacher t=new Teacher();
		t.setCourseid(1);
		t.setEmail("1313");
		t.setId(1);
		t.setName("12313");
		t.setPassword("46548764");
		teachermapper.addTeacher(t);*/
		System.out.println(studentmapper.FindByEmail("测试邮箱").getName()+headmapper.FindByEmail("777").getName()+teachermapper.FindByEmail("222"));
	}
	
}
