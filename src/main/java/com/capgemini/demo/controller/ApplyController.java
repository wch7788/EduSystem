package com.capgemini.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.demo.bean.Apply;
import com.capgemini.demo.mapper.ApplyMapper;
import com.capgemini.demo.mapper.CouserMapper;
import com.capgemini.demo.mapper.HeadMapper;
import com.capgemini.demo.mapper.TeacherMapper;
import com.capgemini.demo.service.ApplyService;
import com.capgemini.demo.service.ApplyServiceImpl;

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
	public String addApply(HttpServletRequest request,HttpServletResponse response,HttpSession session){
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
		int nextid=applyid+1;
		session.setAttribute("applyid", nextid);
		return "submit_success";	
	}
	
	
	@RequestMapping(value="SearchApply",method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView SearchApply(HttpServletRequest request,HttpServletResponse response,ModelAndView mv){
		Apply a=new Apply();
		
		
		
		String studentname=request.getParameter("studentname");
		System.out.println(studentname);
		if(studentname!=null&&!("".equals(studentname))){a.setStudentname(studentname);}
		
		String studentnumber=request.getParameter("studentid");
		System.out.println(studentnumber);
		if(studentnumber!=null&&!("".equals(studentnumber))){a.setStudentid(studentnumber);}
		
	
		
		String teachername=request.getParameter("teachername");
		System.out.println("教师名："+teachername);
		if(!("".equals(teachername))&&teachername!=null){
			
			if(teachermapper.FindByName(teachername)!=null){
				int teacherid=teachermapper.FindByName(teachername).getId();
				a.setTeacherid(teacherid);
				}else if(teachermapper.FindByName(teachername)==null){
					a.setTeacherid(-1);
				}
		}
		System.out.println("测试");
		String coursename=request.getParameter("coursename");
		if(coursename!=null&&!("".equals(coursename))){
			if(coursemapper.FindByName(coursename)!=null){
			int courseid=coursemapper.FindByName(coursename).getId();
			a.setCourseid(courseid);
			} else{
				a.setCourseid(-1);
			}
		}
		String headname=request.getParameter("head");
		System.out.println("headname");
		if(headname!=null&&!("".equals(headname))){
			if(headmapper.FindByName(headname)!=null){
			int headid=headmapper.FindByName(headname).getId();
			a.setHeadid(headid);
			}else{
				a.setHeadid(-1);
			}
		}
	
		
	    System.out.println(a.getStudentname());
		List<Apply> list=applymapper.FindApplyBySome(a);
		
             
		  mv.addObject("applys", list);
		  mv.setViewName("model");
		  System.out.println(list);
		return mv;
		
	}
	
	
	@RequestMapping(value="THSearchApply",method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView THSearchApply(HttpServletRequest request,HttpServletResponse response,ModelAndView mv){
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
		if(!("".equals(teachername))&&teachername!=null){
			if(teachermapper.FindByName(teachername)!=null){
			int teacherid=teachermapper.FindByName(teachername).getId();
			a.setTeacherid(teacherid);
			}else{
				a.setTeacherid(-1);
			}
		}
		System.out.println("测试");
		if(coursename!=null&&!("".equals(coursename))){
			
			if(coursemapper.FindByName(coursename)!=null){
				int courseid=coursemapper.FindByName(coursename).getId();
				a.setCourseid(courseid);
				} else{
					a.setCourseid(-1);
				}
		}
		String headname=request.getParameter("head");
		System.out.println("headname");
		if(headname!=null&&!("".equals(headname))){
			
			if(headmapper.FindByName(headname)!=null){
				int headid=headmapper.FindByName(headname).getId();
				a.setHeadid(headid);
				}else{
					a.setHeadid(-1);
				}
		}
	
		
	    System.out.println(a.getStudentname());
		List<Apply> list=applymapper.FindApplyBySome(a);
		
             
		  mv.addObject("applys", list);
		  mv.setViewName("review");
		  System.out.println(list);
		return mv;
		
	}
    
	
	@RequestMapping(value="update")
	public ModelAndView updateApply(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		//批准判断
		
		if("confirm".equals(request.getParameter("submit"))){
		if(session.getAttribute("role")=="教师"){
        System.out.println("教师身份");		
	 	String[] a=request.getParameterValues("checkbox");
	 	for(int i=0;i<a.length;i++){
	 		int id= Integer.parseInt(a[i]);
	 		if(applymapper.FindApplyByApllyId(id).getHeadstate()==1){
	 			applymapper.TeacherApproveAndHeadApprove(id);
	 		}else if(applymapper.FindApplyByApllyId(id).getHeadstate()==0){
	 			applymapper.TeacherApprove(id);
	 		}
	 	}
	 	String name=(String) session.getAttribute("thisuseremail");
	 	System.out.println("当前账户邮箱："+name);
	 	int teacherid=teachermapper.FindByEmail(name).getId();
		List<Apply> teacherapplylist=applymapper.FindApplyByTeacherid(teacherid);
		session.setAttribute("role", "教师");
		session.setAttribute("approvelist",teacherapplylist);
		//System.out.println(stringArray[0]+""+stringArray[1]);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("review");
		return mv;
        }else if(session.getAttribute("role")=="主任"){
			
			System.out.println("主任身份");		
		 	String[] a=request.getParameterValues("checkbox");
		 	for(int i=0;i<a.length;i++){
		 		int id= Integer.parseInt(a[i]);
		 		if(applymapper.FindApplyByApllyId(id).getTeacherstate()==1){
		 			applymapper.HeadApproveAndTeacherApprove(id);;
		 		}else if(applymapper.FindApplyByApllyId(id).getTeacherstate()==0){
		 			applymapper.HeadApprove(id);;
		 		}
		 	}
		 	String name=(String) session.getAttribute("thisuseremail");
		 	System.out.println("当前账户邮箱："+name);
		 	int headid=headmapper.FindByEmail(name).getId();
		 	List<Apply> headapplylist=applymapper.FindApplyByHeadid(headid);
			session.setAttribute("approvelist",headapplylist);
			session.setAttribute("role", "主任");
			//System.out.println(stringArray[0]+""+stringArray[1]);
			ModelAndView mv=new ModelAndView();
			mv.setViewName("review");
			return mv;
		} 
	
		
		
     	}else if("reject".equals(request.getParameter("submit"))){
     		
     		 System.out.println("任何人拒绝都直接拒绝");	
     		String[] a=request.getParameterValues("checkbox");
     		
     		for(int i=0;i<a.length;i++){
    	 		int id= Integer.parseInt(a[i]);
    	 		applymapper.THRejectApply(id);
    	 		}
     		
     		if(session.getAttribute("role")=="教师"){
     			String name=(String) session.getAttribute("thisuseremail");
     		 	System.out.println("当前账户邮箱："+name);
     		 	int teacherid=teachermapper.FindByEmail(name).getId();
     			List<Apply> teacherapplylist=applymapper.FindApplyByTeacherid(teacherid);
     			session.setAttribute("role", "教师");
     			session.setAttribute("approvelist",teacherapplylist);
     			//System.out.println(stringArray[0]+""+stringArray[1]);
     			ModelAndView mv=new ModelAndView();
     			mv.setViewName("review");
     			return mv;
     			
     		}else if(session.getAttribute("role")=="主任"){
     			String name=(String) session.getAttribute("thisuseremail");
    		 	System.out.println("当前账户邮箱："+name);
    		 	int headid=headmapper.FindByEmail(name).getId();
    			List<Apply> teacherapplylist=applymapper.FindApplyByTeacherid(headid);
    			session.setAttribute("role", "教师");
    			session.setAttribute("approvelist",teacherapplylist);
    			//System.out.println(stringArray[0]+""+stringArray[1]);
    			ModelAndView mv=new ModelAndView();
    			mv.setViewName("review");
    			return mv;
     			
     			
     		}
     		
    	 	
     	}
	
     	return null;
     		
     		
     		
     	}
		
		
		
		
		
   }
	
	

