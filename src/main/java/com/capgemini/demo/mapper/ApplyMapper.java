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
//待处理的老师apply
List<Apply> FindApplyByTeacherid(@Param("id")int id);

List<Apply> FindApplyByHeadid(@Param("id") int id);
      Apply FindApplyByApllyId(int applyid);
       void TeacherApprove(int applyid);
       void TeacherApproveAndHeadApprove(int applyid);
	
       void HeadApprove(int applyid);
       void HeadApproveAndTeacherApprove(int applyid);
       
       void THRejectApply(int applyid);
}
