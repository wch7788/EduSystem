<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">

	body{
		margin: 0 ;
		padding: 0 ;
	}
	
	#top{
		height: 400px ;
		background-color:rgb(0, 112, 173);
	}
	
	
	#register{
		
		width:400px ; 
		height:350px ; 
		position: fixed ;
		background: #fff ;
		box-shadow: grey 1px 1px 3px 1px ;
		border-radius: 6px ;
		left: 50% ;
		top:200px ;
		margin-left: -200px ;
		
	}
	
		#register .title{
		height: 60px ;
		line-height: 60px ;
		text-align : center ;
		font-size : 20px ;
		
	}
	
	
	 .content{
		width: 300px ;
		margin: 0 auto ;
		position: relative ;
		
	}
	
	#register .content p{
		margin-top: 40px ;
	}
	
	#register p input{
		position: absolute ;
		left: 70px ;
		width: 200px ;
	    height: 40px  ;
	    line-height: 40px ;
	    box-sizing: border-box ;
	    border: 1px solid #ededed ;
	    border-radius: 4px ;
	    vertical-align:middle ;
	    margin:-4px 2px 0px 2px;
	
	}
	
	.rightInput{
		margin-left: 20px ;
		display:none; 
	}
	
	.inputFont{
		
		color: #fff ;
		font-weight: 500;
		background: rgb(18, 171, 219) ;
		margin-top: 40px ;
	}
	
	.inputFont:hover{
		opacity: 0.8 ;
	}
	
	
	.selfInput{
		position: relative ;
		 display: inline-block ;
	}
	.selfInput:after{
		content: "" ;
		display: inline-block ;
         width: 15px ;
         height: 15px;
         border: 1px solid #ededed ;
         position: absolute;
         top: 2px ;
         left: -20px ;
		 box-sizing: content-box ;
		
         border-radius: 15px ;
        
	}
  	input:checked+label:after{
         background-color: rgb(0, 112, 173);
     }
</style>

</head>
<body>

	
	
	<div id="top"></div>
	
	<div id="register" >
		
		<div class="title">
			<span>登陆</span>
		</div>
		<div class="content">
		<form action="confirmlogin" method="post"> 
		<div style="text-align: center">
			<div style="display:inline-block; margin-left:30px ;">
				<input type="radio" class="stu rightInput" name="one" value="student" id="radio1">
				<label class="selfInput" for="radio1">学生</label>
				</div>
				<div style="display:inline-block ;margin-left:30px;" >
				<input type="radio" class="tea rightInput" name="one" id="radio2" value="teacher">
				<label class="selfInput" for="radio2">老师</label>
				</div>
				<div style="display:inline-block ; margin-left:30px;">
				<input type="radio" class="stu rightInput" id="radio3"name="one" value="head">
				<label class="selfInput" for="radio3">教导主任</label>
				</div>
		</div>
			<p><label>用户名: </label><input type="text" name="email" placeHolder="请输入邮箱" required></p>
			<p><label>密码: </label><input type="password" name="password" placeHolder="请输入密码" required></p>
			<p  style="text-align: center"><input type="submit" value="登陆" class="inputFont"></p>
		</form>
		</div>
	</div>
</body>
<script type="text/javascript">
window.onload=function () {
	   if("${requestScope.msg}"=="登录失败"){
		   alert("登录失败");
	   }
	   
	   if("${requestScope.msg}"=="注册成功"){
		   alert("注册成功");
	   }
	   
	   
};


</script>

</html>