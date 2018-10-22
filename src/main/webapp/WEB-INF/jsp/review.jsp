<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>申请</title>
</head>
<style>
/* 按钮 */
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
/* 按钮结束 */
*{
    margin: 0;
    padding: 0;    
}
body{
    background-color: #ededed;
}

table{
 border-collapse:collapse;
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
    border-radius: 6px 6px 0 0;
}
.main-header div:nth-child(2){
    width: 15%;
    height: 100%;
    float: left;
    text-align: center;
    line-height: 45px;
    border-radius: 6px 6px 0 0;
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
}
.main-content div:nth-child(2){
    width: 100%;
    height: 540px;
    display: none;
}


/* 审批的表格*/
.review{
    margin:10px auto;
    border-collapse: collapse;
}
.review thead,tr{
    border-bottom: 1px solid #e5e5e5;
  	
    padding: 2px 0;
}
.review tbody tr:hover{
    background-color: #ededed;
}
.review th,td{
    text-align: center;
    padding: 15px 30px;
    font-size: 14px;
    margin-top:10px;
}

/*###apply*/
#apply {
	text-align: center ;
}

#apply button{	
	margin-right: 10px ;
}

/*####search*/
#search{
	width: 80% ;
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

#table thead th{
	padding:5px 10px;
	
}

#table table tbody tr{

	 border-bottom: 1px solid #e5e5e5;
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
           <div id="apply-btn">审批</div>
           <div id="search-btn">查询</div>
        </div>
        <div class="main-content">
            <!-- 审批 -->
         
            
            <!-- 查询 -->
            <div id="search">
                	 <form action="THSearchApply">
               	
               	        学生名: <input type="text" name="studentname">
               		学号: <input type="text" name="studentid">	
               		老师名: <input type="text" name="teachername">
               		课程名:	<input type="text" name="coursename">
               		教导主任:<input type="text" name="head"> 
               		
               		<input type="submit" value="查询" class=" primary-button"  >
               		
               </form>
               
               <div id="table" style="display:block ; margin-top: 60px ; overflow-y:auto; height:400px;">
               		<table>
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
            
               <div id="apply" style=" ">
              <form action="update" method="get">
                <table class="review">
                    <thead>
                    	
                    	<th><input type="checkbox" id="allInput" name="all" ></th>
                        <th>学号</th>
                        <th>学生</th>
                        <th>课程</th>
                        <th>老师</th>
                        <th>教导主任</th>
                        <th>邮箱</th>  
                        
                    </thead>
                    
                    <tbody>
                     <c:forEach var="approve" items="${approvelist}">
                     <tr>
                     <td><input type="checkbox" id="allInput" name="checkbox" value="${approve.id}" ></td>
                     <td> ${approve.studentid}</td>
                     <td> ${approve.studentname}</td>
                     <td> ${approve.course.name}</td>
                     <td> ${approve.teacher.name}</td>
                     <td> ${approve.head.name}</td>
                     <td> ${approve.email}</td>
                     </tr>
                     </c:forEach>
                    </tbody>
                </table>
                
                <button type="submit" class="primary-button" name="submit" value="confirm">
                	通过
                </button>
                
                 <button type="submit" class="warning-button" name="submit" value="reject">
                	拒绝
                </button>
                </form>
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
        },500)
}
// loading 	
    window.onload = function(){
        searchBtn.classList.add("white");
    }

    let applyBtn = document.getElementById("apply-btn");
    let searchBtn = document.getElementById("search-btn");
    let apply = document.getElementById("apply");
    let search = document.getElementById("search");
    let allInput = document.getElementById("allInput") ;
    let input = document.getElementsByTagName("input")
    
    allInput.onchange = function(event){
    	console.log(event) ;
    	if(event.target.checked == true){
	    	for(let i in input){
	    		input[i].checked = true ;
	    	}
    	}else{
    		for(let i in input){
	    		input[i].checked = false ;
	    	}
    	}
    }
    
    $(function () {
	    //全选,设置chheckbox name='all' tbody id=tb
	    $("input[name=all]").click(function () {
	        if (this.checked) {
	            $("#tb :checkbox").prop("checked", true);
	        } else {
	            $("#tb :checkbox").prop("checked", false);
	        }
	    });
	});
    
    function userCheck(ths) {
        if (ths.checked == false) {
            $("input[name=all]:checkbox").prop('checked', false);
        }
        else {
            var count = $("input[name='id']:checkbox:checked").length;
            if (count == $("input[name='id']:checkbox").length) {
                $("input[name=all]:checkbox").prop("checked", true);
            }
        }
    }
    
    
    
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



</script>
</html>