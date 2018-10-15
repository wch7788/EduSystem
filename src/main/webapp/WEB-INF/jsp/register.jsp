<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style type="text/css">

	#login{
	
		width:400px ;
		height: 500px ;
		margin: 0 auto ;
		background: #ededed ;
		position: relative ;
	}
	
	#login .title{
		height: 60px ;
		line-height: 60px ;
		text-align : center ;
		font-size : 20px ;
		border-bottom: 1px solid #f2f2f2 ;
	}
	
	#login .content{
		width: 300px ;
		margin: 0 auto ;
	
	}
	
	#login .content p{
		margin-top : 40px ;
	}
	
	#login .content p input  {
		position: absolute ;
		left: 120px ;
		width: 200px ;
	    height: 40px  ;
	    line-height: 40px ;
	    box-sizing: border-box ;
	   
	    border: 0 ;
	    border-radius: 4px ;
	    vertical-align:middle ;
	    margin:-6px 2px 0px 2px;
	
	}
	

	
	
	#login .content p select{
		position: absolute ;
		left: 120px ;
		width: 200px ;
	    height: 40px  ;
	
	}
	
	.course{
		display: none ;
	}
	
</style>



</head>
<body>
	
	<div id="login">
		<div class="title">
			<span>注册</span>
		</div>
		
		<div class="content">
			<form action="confirmregister">
				<input type="radio" class="stu" name="one" value="student">学生<input type="radio" class="tea" name="one" value="teacher">老师
				<input type="radio" class="stu" name="one" value="head">教导主任
				<p><label>用户名</label> <input type="text" name="username"></p>
				<p><label>邮箱</label> <input type="text" name="email"></p>
				<p><label>密码</label> <input type="password" name="password"></p>
				<p class="course"><label>课程</label>
				<select name="lesson">
				<option value="1">语文</option>
				<option value="2">数学</option>
				<option value="3">英语</option>
				</select></p>
				<p><input type="submit" value="注册"></p>
				
			</form>
			
		</div>
	</div>
</body>

<script>
	
	$(".tea").change(function(e){
		$(".course").css("display","block")
	})
	
	$(".stu").change(function(e){
		$(".course").css("display","none")
	})
</script>
</html>