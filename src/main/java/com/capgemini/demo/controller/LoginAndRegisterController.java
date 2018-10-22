package com.capgemini.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.demo.bean.Apply;
import com.capgemini.demo.bean.Course;
import com.capgemini.demo.bean.Head;
import com.capgemini.demo.bean.Student;
import com.capgemini.demo.bean.Teacher;
import com.capgemini.demo.mapper.ApplyMapper;
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
	@Autowired
	ApplyMapper applymapper;
	
	
	
	@RequestMapping(value="ceshi")
	public String ceshi(){
		return "77";
	}

	//进入注册界面
	@RequestMapping(value="register")
	public String Register(HttpServletRequest request,HttpServletResponse response){
		
		request.setAttribute("msg", "");
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
				request.setAttribute("msg", "注册成功");

				System.out.println("注册成功");
				return "login";
			}
			request.setAttribute("msg", "注册失败");
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
				request.setAttribute("msg", "注册成功");

				System.out.println("注册成功");
				return "login";
			}
			request.setAttribute("msg", "注册失败");
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
				request.setAttribute("msg", "注册成功");

				System.out.println("注册成功");
				return "login";
			}
			request.setAttribute("msg", "注册失败");
			System.out.println("注册失败");
			return "register";
			
			
		}
		
		
		request.setAttribute("msg", "注册失败");
		return "register";
		
		
		
	}
	
	
	@RequestMapping(value="login")
	public String loginin(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("msg", "进入登录页面");
		return "login";
	}
	
	//登录成功后进入主页面
	@RequestMapping(value="confirmlogin")
	public ModelAndView ConfirmLogin(HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();

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
				 session=request.getSession();
				session.setAttribute("applyid", applyid);
				session.setAttribute("courselist", courselist);
				session.setAttribute("headlist", Headlist);
				session.setAttribute("studentname", studentname);
				session.setAttribute("teacherlist1", teacherlist1);
				session.setAttribute("teacherlist2", teacherlist2);
				session.setAttribute("teacherlist3", teacherlist3);

				mv.setViewName("login_success");
		       
				System.out.println(teacherlist1);
				
				return mv;
			}else{
				request.setAttribute("msg", "登录失败");

				System.out.println("登录失败");
				return new ModelAndView("login");
			}
			
		}
		
		if("teacher".equals(radioname)){
			if(teacherservice.checklogin(name,password)){
				
				System.out.println("登录成功");
				
				session.setAttribute("thisuseremail", name);
				int teacherid=teachermapper.FindByEmail(name).getId();
				List<Apply> teacherapplylist=applymapper.FindApplyByTeacherid(teacherid);
				session.setAttribute("role", "教师");
				session.setAttribute("approvelist",teacherapplylist);
				return new ModelAndView("login_success_TH");
			}else{
				request.setAttribute("msg", "登录失败");
				System.out.println("登录失败");
				return new ModelAndView("login");
			}
			
		}
		
		
		if("head".equals(radioname)){
			if(headservice.checklogin(name,password)){
				session.setAttribute("thisuseremail", name);
				int headid=headmapper.FindByEmail(name).getId();
				List<Apply> headapplylist=applymapper.FindApplyByHeadid(headid);
				session.setAttribute("approvelist",headapplylist);
				session.setAttribute("role", "主任");

				System.out.println("登录成功");
				return new ModelAndView("login_success_TH");
			}else{
				request.setAttribute("msg", "登录失败");
				System.out.println("登录失败");
				return new ModelAndView("login");
			}
			
		}
		
		System.out.println("登录失败");
		return null;
		
		
	
		
	}
	
	@RequestMapping(value="homepage")
	public String HomePage(){
		return "model";
	}
	
	
	@RequestMapping(value="THhomepage")
	public String THHomePage(){
		return "review";
	}
}
