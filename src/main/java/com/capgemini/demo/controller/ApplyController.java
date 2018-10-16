package com.capgemini.demo.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.demo.bean.Apply;
import com.capgemini.demo.mapper.ApplyMapper;
import com.capgemini.demo.mapper.CouserMapper;
import com.capgemini.demo.mapper.HeadMapper;
import com.capgemini.demo.mapper.TeacherMapper;
import com.capgemini.demo.service.ApplyService;
import com.capgemini.demo.service.ApplyServiceImpl;

import ch.qos.logback.classic.net.SyslogAppender;

@Controller
public class ApplyController {
	@Autowired
	private ApplyService applyservice=new ApplyServiceImpl();
	@Autowired
	private ApplyMapper applymapper;
	@Autowired
	HeadMapper headmapper;
	@Autowired
	TeacherMapper teachermapper;
	@Autowired
	CouserMapper coursemapper;
	
	
	
	@RequestMapping(value="addApply")
	public String addApply(HttpServletRequest request,HttpServletResponse response){
		int applyid=Integer.parseInt((request.getParameter("id")));
		
		String studentname=request.getParameter("name");
		
		int courserid=Integer.parseInt((request.getParameter("course")));
	
		int headid=Integer.parseInt((request.getParameter("head")));
	
		String s=String.valueOf(courserid);
	
		
		int teacherid=Integer.parseInt(request.getParameter(s));
		
		
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String studentnumber=request.getParameter("number");
		java.sql.Date time= new java.sql.Date(new java.util.Date().getTime());
		System.out.println(time);
		Apply apply=new Apply(applyid,studentname,courserid,teacherid,headid,email,phone,studentnumber,time,0,0,0);
		
		applyservice.addApply(apply);
		return "sucess";	
	}
	
	
	@RequestMapping(value="SearchApply")
	public ModelAndView SearchApply(HttpServletRequest request,HttpServletResponse response){
		Apply a=new Apply();
		
		
		
		String studentname=request.getParameter("studentname");
		System.out.println(studentname);
		if(studentname!=null&&!("".equals(studentname))){a.setStudentname(studentname);}
		
		String studentnumber=request.getParameter("studentid");
		System.out.println(studentnumber);
		if(studentnumber!=null&&!("".equals(studentnumber))){a.setStudentid(studentnumber);}
		String coursename=request.getParameter("coursename");
		System.out.println(coursename);
		
		String teachername=request.getParameter("teachername");
		System.out.println(teachername);
		if(teachername!=null&&!("".equals(teachername))){
			
			int teacherid=teachermapper.FindByName(teachername).getId();
			a.setTeacherid(teacherid);
		}
		System.out.println("测试");
		if(coursename!=null&&!("".equals(coursename))){
			
			int courseid=coursemapper.FindByName(coursename).getId();
			a.setCourseid(courseid);
		}
		String headname=request.getParameter("head");
		System.out.println("headname");
		if(headname!=null&&!("".equals(headname))){
			
			int headid=headmapper.FindByName(headname).getId();
			a.setHeadid(headid);
		}
	
		
	
	
		
		System.out.println(a.getStudentname());
		List<Apply> list=applymapper.FindApplyBySome(a);
		
		ModelAndView mv=new ModelAndView();
		  mv.setViewName("index");
		  System.out.println(list);
		return mv;
		
	}
    
}
