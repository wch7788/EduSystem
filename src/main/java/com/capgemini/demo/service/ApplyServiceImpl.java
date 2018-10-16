package com.capgemini.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.demo.bean.Apply;
import com.capgemini.demo.mapper.ApplyMapper;

@Repository("ApplyService")
public class ApplyServiceImpl implements ApplyService{
	@Autowired
	private ApplyMapper applymapper;

	@Override
	public int CountApply() {
       int id=applymapper.CountApply()+1;
		return id;
	}

	@Override
	public void addApply(Apply apply) {

		applymapper.addApply(apply);
	}
	
	

}
