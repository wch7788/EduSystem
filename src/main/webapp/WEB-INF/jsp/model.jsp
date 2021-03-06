<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<!DOCTYPE html>
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

 
 
 .primary-button{
    border-radius: 3px;
    color: #fff;
    padding: 3px 6px;
    border:1px solid transparent;
    background-color: rgb(0, 112, 173);
}
.primary-button:hover{
    background-color: #286090;
    border-color: #204d74;
}

.warning-button{
    padding: 3px 6px;
    border:1px solid transparent;    
    color: #fff;
    background-color: #c9302c;
    border-color: #ac2925;
    border-radius: 3px;
}
.warning-button:hover{
    opacity: 0.8;    
}


body{
    background-color: #ededed;
}


table{
 border-collapse:collapse;
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
	width: 80%;
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

#table{
	
	margin: 10px auto ;
	font-size: 14px ;
}

#table thead th{
	padding:5px 10px;
	
}

#table tbody tr{

	border-bottom: 1px solid rgb(204, 204, 204) ;
}

#table tbody tr td{
	 text-align: center;
    padding: 15px 30px;
    font-size: 14px;
    margin-top:10px;
}



.review thead,tr{
    border-bottom: 1px solid #e5e5e5;
  	
    padding: 2px 0;
}
.review tbody tr:hover{
    background-color: #ededed;
}



   /* loading动画 */
    #loading{
        width: 100%;
        height: 100%;
        position: fixed;
        background-color: #ededed;
        opacity: 0.8;
        animation: loadhide 1s infinite linear;
    }
    #circle{
        margin: 15% auto;
        width: 66px;
        height: 66px;
        border: 5px white solid;
        border-left-color: #ff5500;
        border-right-color:#0c80fe;
        border-radius: 100%;
        animation: loading1 1s infinite linear;
    }
    @keyframes loadhide{
        from{
           
        }to{
            opacity: 0.2;
        }
    }
    @keyframes loading1{
        from{
            transform: rotate(0deg)
        }to{
            transform: rotate(360deg);
        }
    }
    .hide{
        display: none;
    }
    /* loading动画结束 */

</style>

<body>

  <!-- loading动画 -->
    <div id="loading">
        <div id="circle"></div>
    </div>
    
    <!-- loading动画 -->
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
				<li>申请号:<input  name="id"   type="text" value="${sessionScope.applyid}"></li>
				<li>学生名:<input name="name" type="text" value="${sessionScope.studentname}"></li>
				<li>课程: <select id="course" name="course"><option>请选择课程</option><c:forEach var="course" items="${sessionScope.courselist}"><option value="${course.id}">${course.name}</option></c:forEach></select>  </li>
				<li>老师:  <select class="teacher"><option>请选择老师</option></select> 
						  <select class="teacher" name="1"> <c:forEach var="teacherlist1" items="${sessionScope.teacherlist1}"><option value="${teacherlist1.id}"> ${teacherlist1.name}</option></c:forEach> </select> 
						  <select class="teacher" name="2"> <c:forEach var="teacherlist2" items="${sessionScope.teacherlist2}"><option value="${teacherlist2.id}"> ${teacherlist2.name}</option></c:forEach> </select> 
						  <select class="teacher" name="3"> <c:forEach var="teacherlist3" items="${sessionScope.teacherlist3}"><option value="${teacherlist3.id}"> ${teacherlist3.name}</option></c:forEach> </select>  
						  </li>
				<li>
				教导主任:<select name="head">
				<option>请选择教导主任</option>
				<c:forEach var="head" items="${sessionScope.headlist}">
				<option value="${head.id}">${head.name}</option>
				</c:forEach>
				</select>
				</li>
				<li>邮箱:<input name="email" type="text"></li>
				<li>手机号:<input name="phone" type="text"></li>
				<li>学号:<input name="number" type="text"></li>
				<li><button type="submit" class="addColor" >提交</button> <button type="reset">取消</button></li>
				</ul>
			</form>
            </div>
            <div id="search">
            	
               <form action="SearchApply">
               	
               		学生名: <input type="text" name="studentname">
               		学号: <input type="text" name="studentid">	
               		老师名: <input type="text" name="teachername">
               		课程名:	<input type="text" name="coursename">
               		教导主任:<input type="text" name="head"> 
               		
               		<input type="submit" value="查询" class=" primary-button">
               		
               </form>
               
               <div id="table" style="display:block ; margin-top: 60px ;  overflow-y:auto; height:400px;">
               		<table >
               			<thead>
               			
               				<th>课程名</th>
               				<th>学生名</th>
               				<th>老师名</th>
               				<th>主任名</th>
               				<th>email</th>
               				<th>电话</th>
               				<th>学号</th>
               				<th>选课时间</th>
               				<th>状态</th>
               			
               			</thead>
               			
               			<tbody>
               			<c:forEach  var="apply" items="${applys}">
               			<tr>
               			<td>${apply.course.name}</td>
               			<td>${apply.studentname}</td>
               			<td>${apply.teacher.name}</td>
               			<td>${apply.head.name}</td>
               			<td>${apply.email}</td>
               			<td>${apply.phone}</td>
               			<td>${apply.studentid}</td>
               			<td>${apply.date}</td>
               			<td>
               			<s:if test="${apply.state==0}">待审批</s:if>
               			<s:if test="${apply.state==1}">审批中</s:if>
               			<s:if test="${apply.state==2}">已通过</s:if>
               			<s:if test="${apply.state==3}">未通过</s:if>
               			</td>
               			</tr>
               			</c:forEach>
               				
               			</tbody>
               		</table>
               </div>
            </div>
        </div>
    </div>
</body>


<script>

// loading
let loading = document.getElementById("loading");
if(document.readyState == "loading"){
    setTimeout(
        function(){
            loading.classList.add("hide");
        },500
    )
}
// loading

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