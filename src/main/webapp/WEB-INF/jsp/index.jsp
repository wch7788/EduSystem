<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>jQuery 二级联动</title> 
  <script src="http://img.jb51.net/jslib/jquery/jquery.js" type="text/javascript"></script> 
  <script type="text/javascript"> 
$(document).ready(function(){ 
$("#course").change(function(){ 
$("#course option").each(function(i,o){ 
if($(this).attr("selected")) 
{ 
$(".teacher").hide(); 
$(".teacher").eq(i).show(); 
} 
}); 
}); 
$("#course").change(); 
}); 
</script> 
 </head> 
 <body> 
 <form>
  <select id="course" name="course"><option>请选择课程</option><c:forEach var="course" items="${courselist}"><option value="${course.id}">${course.name}</option></c:forEach></select> 
  <select class="teacher" ><option>请选择老师</option></select> 
  <select class="teacher" name="1Chinese"> <c:forEach var="teacherlist1" items="${teacherlist1}"><option value="${teacherlist1.id}"> ${teacherlist1.name}</option></c:forEach> </select> 
  <select class="teacher" name="2Math"> <c:forEach var="teacherlist2" items="${teacherlist2}"><option value="${teacherlist2.id}"> ${teacherlist2.name}</option></c:forEach> </select> 
  <select class="teacher" name="3English"> <c:forEach var="teacherlist3" items="${teacherlist3}"><option value="${teacherlist3.id}"> ${teacherlist3.name}</option></c:forEach> </select>  
<input type="submit" value="提交"/>

</form>


<br></br><br></br>
<c:forEach var="course" items="${courselist}">
 ${course.name}

</c:forEach>

<c:forEach var="teacher" items="${teacherlist1}">
  ${teacher.name}

</c:forEach>


 </body>
</html>
