<%@ page language="java"  pageEncoding="UTF-8"%>
	<!DOCTYPE HTML>

<html>
   <head>            
   		<meta charset = "utf-8">
		<title>出错了</title>
		<link href = "css/error.css" rel = "stylesheet" />
   </head> 
   
     <body>
			<div class = "box">
				<div class = "content">
					<h1>ERROR</h1>
					<p id = "errorInfo">${info}</p>
					
					<p><span id = "mes">10</span>秒后自动返回主界面</p>
					
					<p>不能跳转，请<a href="login.html"> 点击这儿</a></p>
					<script type="text/javascript" src="js/error.js"></script>
				</div>
			</div>
				
					
     </body>
        
</html>        
