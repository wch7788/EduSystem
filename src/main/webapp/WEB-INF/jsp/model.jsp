<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://img.jb51.net/jslib/jquery/jquery.js"></script>
<title>申请</title>
</head>
<style>
*{
   
    margin: 0;
    padding: 0;    
}
body{
    background-color: #ededed;
}

button{
	width: 80px ;
	height: 30px ;
	border-radius: 3px ;
	margin-right: 30px ;
	border: none ;
}

button:hover{
	
}

.teacher{
	position: absolute ;
	left: 0 ;
	top: 0 ;	
}
.header{
    width: 100%;
    height: 60px;
    background-color: rgb(0, 112, 173);
}


.main{
    width: 85%;
    background-color: #fff;
    height: 600px;
    margin: 0 auto;
}

.main-header{
    width: 100%;
    height: 45px;
    background-color: rgb(136, 213, 237)
}
.main-header div:first-child{
    width: 15%;
    height: 100%;
    float: left;
    text-align: center;
    line-height: 45px;
}
.main-header div:nth-child(2){
    width: 15%;
    height: 100%;
    float: left;
    text-align: center;
    line-height: 45px;
}
.white{
    background-color: #fff;
}

.main-content{
    width: 100%;
    height: 540px;
}

.main-content div:nth-child(1){
    width: 100%;
    height: 540px;
    display: none;
}
.main-content div:nth-child(2){
    width: 100%;
    height: 540px;
    
}

#apply{
	width:600px ;
	margin: 0 auto ;
	
}

#apply ul{
	margin-top: 20px ;
}

#apply ul li {
	list-style: none;
	margin-bottom: 15px ;
	height: 40px ;
	position: relative ;
	font-size: 20px ;
	font-weight: 400 ;
	
}

#apply ul li input,#apply ul li select{
	position: absolute ;
	left: 100px ;
     	
    border-radius: 4px ;
    line-height: 30px ;
    width: 200px ; 
    border: 1px solid rgb(204, 204, 204) ;
}

#apply ul li select{
	width: 100px;
}

.addColor{
	background: rgb(0, 112, 173) ;
}


/*######search*/
#search{
	width: 900px ;
	margin: 0 auto ;
	margin-top: 20px ;
	position: relative ;
}

#search form input{
 	border-radius: 4px ;
    line-height: 25px ;
    width: 100px ; 
    border: 1px solid rgb(204, 204, 204) ;
    margin-right : 20px ;
}

#search form select{
	border-radius: 4px ;
    line-height: 25px ;
    width: 80px ; 
    border: 1px solid rgb(204, 204, 204) ;
    margin-right : 20px ;
}

.right{
	position: absolute ;
	right: 50px ;
	top: 50px ;
}

table thead th{
	width: 80px ;
	margin-right: 20px ;
}

table tbody tr{

	border-bottom: 1px solid rgb(204, 204, 204) ;
}

</style>

<body>
    <div class="header"></div>
    <div class="main">
        <div class="main-header">
           <div id="apply-btn">申请</div>
           <div id="search-btn">查询</div>
        </div>
        <div class="main-content">
            <div id="apply">
            <form id="form" method="get" action="addApply">
            	<ul>
				<li>申请号:<input  name="id"   type="text" value="${applyid}"></li>
				<li>学生名:<input name="name" type="text" value="${studentname}"></li>
				<li>课程: <select id="course" name="course"><option>请选择课程</option><c:forEach var="course" items="${courselist}"><option value="${course.id}">${course.name}</option></c:forEach></select>  </li>
				<li>老师:  <select class="teacher"><option>请选择老师</option></select> 
						  <select class="teacher" name="1"> <c:forEach var="teacherlist1" items="${teacherlist1}"><option value="${teacherlist1.id}"> ${teacherlist1.name}</option></c:forEach> </select> 
						  <select class="teacher" name="2"> <c:forEach var="teacherlist2" items="${teacherlist2}"><option value="${teacherlist2.id}"> ${teacherlist2.name}</option></c:forEach> </select> 
						  <select class="teacher" name="3"> <c:forEach var="teacherlist3" items="${teacherlist3}"><option value="${teacherlist3.id}"> ${teacherlist3.name}</option></c:forEach> </select>  
						  </li>
				<li>
				教导主任:<select name="head">
				<option>请选择教导主任</option>
				<c:forEach var="head" items="${headlist}">
				<option value="${head.id}">${head.name}</option>
				</c:forEach>
				</select>
				</li>
				<li>邮箱:<input name="email" type="text"></li>
				<li>手机号:<input name="phone" type="text"></li>
				<li>学号:<input name="number" type="text"></li>
				<li><button type="submit" class="addColor" >提交</button> <button>取消</button></li>
				</ul>
			</form>
            </div>
            <div id="search">
            	
               <form action="SearchApply">
               	
               		学生名: <input type="text" name="studentname">
               		学号: <input type="text" name="studentid">	
               		老师名: <input type="text" name="teachername"><br>
               		课程名:	<input type="text" name="coursename">
               		教导主任:<input type="text" name="head"> </br>
               		
               		<input type="submit" value="查询" class="right">
               		
               </form>
               
               <div id="table" style="display:block ; margin-top: 60px ;">
               		<table>
               			<thead>
               				<tr>
               				<th>课程名</th>
               				<th>学生名</th>
               				<th>老师名</th>
               				<th>主任名</th>
               				<th>email</th>
               				<th>电话</th>
               				<th>学号</th>
               				<th>选课时间</th>
               				<th>状态</th>
               				</tr>
               			</thead>
               			
               			<tbody>
               				<tr></tr>
               			</tbody>
               		</table>
               </div>
            </div>
        </div>
    </div>
</body>


<script>
    window.onload = function(){
        searchBtn.classList.add("white");
    }

    let applyBtn = document.getElementById("apply-btn");
    let searchBtn = document.getElementById("search-btn");
    let apply = document.getElementById("apply");
    let search = document.getElementById("search");
    
    applyBtn.onclick = function(){
        showApply();
        hideSearch();
        applyBtn.classList.add("white");
        searchBtn.classList.remove("white");
    }
    searchBtn.onclick = function(){
        showSearch();
        hideApply();
        searchBtn.classList.add("white");
        applyBtn.classList.remove("white");
    }
    function showApply(){
        apply.style.display = "block";
    }
    function hideApply(){
        apply.style.display = "none";
    }
    function showSearch(){
        search.style.display = "block";
    }
    function hideSearch(){
        search.style.display = "none";
    }

    
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
</html>