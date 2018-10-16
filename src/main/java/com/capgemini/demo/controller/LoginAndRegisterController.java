package com.capgemini.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.demo.bean.Course;
import com.capgemini.demo.bean.Head;
import com.capgemini.demo.bean.Student;
import com.capgemini.demo.bean.Teacher;
import com.capgemini.demo.mapper.CouserMapper;
import com.capgemini.demo.mapper.HeadMapper;
import com.capgemini.demo.mapper.StudentMapper;
import com.capgemini.demo.mapper.TeacherMapper;
import com.capgemini.demo.service.ApplyService;
import com.capgemini.demo.service.ApplyServiceImpl;
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
	@Autowired
	private ApplyService applyservice=new ApplyServiceImpl();
	@Autowired
	TeacherMapper teachermapper;
	@Autowired
	CouserMapper coursemapper;
	@Autowired
	HeadMapper headmapper;
	@Autowired
	StudentMapper studentmapper;
	
	

	//进入注册界面
	@RequestMapping(value="register")
	public String Register(HttpServletRequest request,HttpServletResponse response,HttpServletRequest httprequest){
        httprequest.setAttribute("warn", "登陆失败");   
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
			return "login";
			
			
		}
		
		
		
		return "login";
		
		
		
	}
	
	//登录成功后进入主页面
	@RequestMapping(value="confirmlogin")
	public ModelAndView ConfirmLogin(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		String name=request.getParameter("email");
		String password=request.getParameter("password");
		String radioname=request.getParameter("one");
		if("student".equals(radioname)){
			if(studentservice.checklogin(name,password)){
				System.out.println("登录成功");
				
				ModelAndView mv=new ModelAndView();
				List<Course> courselist=coursemapper.FinAllCourse();
				List<Teacher> teacherlist1=teachermapper.FindByCourseId(1);
				List<Teacher> teacherlist2=teachermapper.FindByCourseId(2);
				List<Teacher> teacherlist3=teachermapper.FindByCourseId(3);
				List<Head> Headlist=headmapper.FindAllHead();
				String studentname=studentmapper.FindByEmail(name).getName();
				int applyid=applyservice.CountApply();
				mv.addObject("applyid", applyid);
				mv.addObject("studentname", studentname);
				mv.addObject("headlist", Headlist);
				mv.addObject("courselist", courselist);
				mv.addObject("teacherlist1", teacherlist1);
				mv.addObject("teacherlist2", teacherlist2);
				mv.addObject("teacherlist3", teacherlist3);
				mv.setViewName("model");
				System.out.println(teacherlist1);
				return mv;
			}else{
				System.out.println("登录失败");
				return new ModelAndView("login");
			}
			
		}
		
		if("teacher".equals(radioname)){
			if(teacherservice.checklogin(name,password)){
				System.out.println("登录成功");
				return new ModelAndView("index");
			}else{
				System.out.println("登录失败");
				return new ModelAndView("login");
			}
			
		}
		
		
		if("head".equals(radioname)){
			if(headservice.checklogin(name,password)){
				System.out.println("登录成功");
				return new ModelAndView("index");
			}else{
				System.out.println("登录失败");
				return new ModelAndView("login");
			}
			
		}
		
		System.out.println("登录失败");
		return null;
		
		
	
		
	}
}
