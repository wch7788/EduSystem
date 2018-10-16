package com.capgemini.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.capgemini.demo.bean.Apply;

@Mapper
public interface ApplyMapper {
	int CountApply();

	void addApply(Apply apply);

/*List<Apply> FindApplyBySome(@Param("name") String studentname,@Param("number") String studentnumber,@Param("cid") int courseid, @Param("tid")int teacherid, @Param("hid")int headid);*/
List<Apply> FindApplyBySome(Apply a);

	
}
