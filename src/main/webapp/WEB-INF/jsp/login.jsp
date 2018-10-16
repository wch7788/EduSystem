<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">

	
	#register{
		width:400px ; 
		height:300px ; 
		
		background:#ededed ; 
		margin: 100px auto ;
		border-radius: 2px ;
		
		position: relative ;	
	}
	
	 .content{
		width: 300px ;
		margin: 0 auto ;
		position: relative ;
		top: 80px ;
		
		
		
	}
	
	#register .content p{
	
		margin-top: 40px ;
	}
	
	#register p input{
		position: absolute ;
		left: 100px ;
		width: 200px ;
	    height: 40px  ;
	    line-height: 40px ;
	    box-sizing: border-box ;
	    
	    border: 0 ;
	    border-radius: 4px ;
	    vertical-align:middle ;
	    margin:-4px 2px 0px 2px;
	
	}
	
	
	
	
	
</style>

</head>
<body>

	
	
	<div id="register" >
		
		
		<div class="content">
		<form action="confirmlogin">
		<input type="radio" class="stu" name="one" value="student">学生<input type="radio" class="tea" name="one" value="teacher">老师
		 <input type="radio" class="stu" name="one" value="head">教导主任
			<p><label>用户名: </label><input type="text" name="email" placeHolder="请输入邮箱"></p>
			<p><label>密码: </label><input type="password" name="password" placeHolder="请输入密码"></p>
			<p><input type="submit" value="登陆"></p>
		</form>
		</div>
	</div>
</body>
</html>