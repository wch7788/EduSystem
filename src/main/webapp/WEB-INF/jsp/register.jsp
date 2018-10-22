<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style type="text/css">


	body{
		margin: 0 ;
		padding: 0 ;
	}
	
	.rightInput{
		margin-left: 20px ;
		display: none ;
	}

	#top{
		height: 400px ;
		background-color:rgb(0, 112, 173);
	}
	
	#login{
		
		width:400px ;
		height: 450px ;
		position: fixed ;
		background: #fff ;
		box-shadow: grey 1px 1px 3px 1px ;
		border-radius: 6px ;
		left: 50% ;
		top:200px ;
		margin-left: -200px ;
	}
	
	#login .title{
		height: 60px ;
		line-height: 60px ;
		text-align : center ;
		font-size : 20px ;
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
	   
	      border: 1px solid #ededed ;
	    border-radius: 4px ;
	    vertical-align:middle ;
	    margin:-6px 2px 0px 2px;
	
	}
	
	#login .content p select{
		position: absolute ;
		left: 120px ;
		width: 200px ;
	    height: 40px  ;
	      border: 0 ;
	    border-radius: 4px ;
	    vertical-align:middle ;
	    margin:-6px 2px 0px 2px;
	
	}
	
	.course{
		display: none ;
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
	
	/*###*/
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
	
	<div id="login">
		<div class="title">
			<span>注册</span>
		</div>
		
		<div class="content">
			<form action="confirmregister" method="post">
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
				<p><label>用户名</label> <input type="text" name="username"></p>
				<p><label>邮箱</label> <input type="text" name="email"></p>
				<p><label>密码</label> <input type="password" name="password"></p>
				<p class="course"><label>课程</label>
				<select name="lesson">
				<option value="1">语文</option>
				<option value="2">数学</option>
				<option value="3">英语</option>
				</select></p>
				<p><input type="submit" value="注册" class="inputFont"></p>
				
			</form>
			
		</div>
	</div>
</body>

<script>
         $(function () {
	   if("${requestScope.msg}"!=""){
		   alert("注册失败");
	   }
	   
	   
}) 
	
	
	$(".tea").change(function(e){
		$(".course").css("display","block")
	})
	
	$(".stu").change(function(e){
		$(".course").css("display","none")
	})
</script>
</html>