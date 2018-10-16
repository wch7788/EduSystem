package com.capgemini.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.capgemini.demo.bean.Head;

@Mapper
public interface HeadMapper {

	void addHead(Head head);

	int CountHead();
   public Head FindByEmail(String email);
   public List<Head> FindAllHead();
   
   public Head FindByName(String name);
}
