package com.capgemini.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.demo.bean.Head;
import com.capgemini.demo.mapper.HeadMapper;

@Repository("HeadService")
public class HeadServiceImpl implements HeadService{
	@Autowired
	private HeadMapper headmapper;

	@Override
	public boolean checkRegister(Head head) {
		  if(head.getName()==""||head.getName()==null){ return false;}
	      if(head.getEmail()==""||head.getEmail()==null){return false;}
	      if(head.getPassword()==""||head.getPassword()==null){return false;}
			
			return true;
	}

	@Override
	public void addHead(Head head) {
          headmapper.addHead(head);
		 
	}

	@Override
	public int AutoID() {
		int id=headmapper.CountHead()+1;
		return id;
	}
	

}
