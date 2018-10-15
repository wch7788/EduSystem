package com.capgemini.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.demo.bean.Head;
import com.capgemini.demo.bean.Student;
import com.capgemini.demo.bean.Teacher;
import com.capgemini.demo.service.HeadService;
import com.capgemini.demo.service.HeadServiceImpl;
import com.capgemini.demo.service.StudentService;
import com.capgemini.demo.service.StudentServiceImpl;
import com.capgemini.demo.service.TeacherService;
import com.capgemini.demo.service.TeacherServiceImpl;

@Controller
public class LoginAndRegisterController {
	
	@Autowired
	private StudentService studentservice=new StudentServiceImpl();
	@Autowired
	private HeadService headservice=new HeadServiceImpl();
	@Autowired
	private TeacherService teacherservice=new TeacherServiceImpl();

	//进入注册界面
	@RequestMapping(value="register")
	public String Register(){
		return "register";
	}
	
	//提交注册信息，注册完成后进入登录界面
	@RequestMapping(value="confirmregister")
	public String ConfirmRegister(HttpServletRequest request,HttpServletResponse response){
		String radioname=request.getParameter("one");
		System.out.println(radioname);
		if("student".equals(radioname) ){
		
		String name=request.getParameter("username");
			String password=request.getParameter("password");
			String email=request.getParameter("email");
			int studentid=studentservice.AutoID();
			Student student=new Student();
			student.setId(studentid);
			student.setEmail(email);
			student.setPassword(password);
			student.setName(name);
			if(studentservice.checkRegister(student)){
				studentservice.addStudent(student);
				System.out.println("注册成功");
				return "login";
			}
			
			System.out.println("注册失败");
			return "register";
			
			
		}
		if("head".equals(radioname)){
			
			String name=request.getParameter("username");
			String password=request.getParameter("password");
			String email=request.getParameter("email");
			int leadid=headservice.AutoID();
			Head head=new Head(leadid,name,password,email);
			if(headservice.checkRegister(head)){
				headservice.addHead(head);
				System.out.println("注册成功");
				return "login";
			}
			System.out.println("注册失败");
			return "register";
		}
		
		if("teacher".equals(radioname)){
			String name=request.getParameter("username");
			String password=request.getParameter("password");
			String email=request.getParameter("email");
			int teacherid=teacherservice.AutoID();
			int courseid=Integer.valueOf(request.getParameter("lesson"));
			Teacher tea=new Teacher(teacherid,name,password,email,courseid);
			if(teacherservice.checkRegister(tea)){
				teacherservice.addTeacher(tea);
				System.out.println("注册成功");
				return "login";
			}
			System.out.println("注册失败");
			return "register";
			
			
		}
		
		
		
		return "register";
		
		
		
	}
	
	//登录成功后进入主页面
	@RequestMapping(value="confirmlogin")
	public String ConfirmLogin(){
		
		return "index";
	}
}
