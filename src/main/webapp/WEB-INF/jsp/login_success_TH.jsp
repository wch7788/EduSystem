<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!doctype html>
<html lang="en">
<head>

	<meta charset="UTF-8">
	<title>Document</title>
	<script>
		
		var url = "THhomepage";
	

		window.onload = function () {
			function bb() {
				var num = Number(number.innerHTML);
				var min = 0;
				function id ()  {
					num--;
					number.innerHTML = num;
					if (num == min) {
						window.location = url;
					} else {
						setTimeout(id, 1000);
					}
				}
				setTimeout(id, 1000);
			}
			bb();
		};
	</script>
</head>
<style>



body {
	background: #F7F7F7;
}
#all {
	width: 300px;
	height: 500px;
	position: absolute;
	left: 50%;
	top: 50%;
	margin-left: -150px;
	margin-top: -250px;
}
#img {
	width: 300px;
	height: 300px;
	margin-left:50px;
	margin-top:10px;
	background: url("success.png") no-repeat;
	
	
	
	
}
.info {
	margin-top: 10px;
	text-align: center;
}
a {
	color: blue;
}
a:hover {
	color: #f60;
}
.time {
	color: #FF7C7C;
	font-weight: bold;
}



</style>
<body>
	<div id="all">

		<div id="img"></div>
		<div class="info">
			<!-- ****************************************************** -->
			<!-- 此处需要修改链接 -->
			<span class="time"><span id="number">3</span>秒</span> 后自动跳转，也可<a href="THhomepage">点击此处直接跳转</a>
			<!-- ****************************************************** -->
		</div>
	</div>
</body>
</html>
