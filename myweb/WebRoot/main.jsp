<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

		<style>
			body {
				margin: 0;
				padding: 0;
				background: #f1f1f1;
				display: flex;
				justify-content: center;
			}
			.menu {
				margin: 0;
				padding: 0;
				margin-top: 200px;
			}
			.menu li {
				list-style: none;
				display: inline-block;
			}
			.menu li a {
				text-decoration: none;
				position: relative;
				color: #313131;
				font-size: 50px;
				font-weight: 700;
				font-family: sans-serif;
				display: block;
				overflow: hidden;
				transition: 0.7s all;
				padding: 14px 30px;
				text-transform: uppercase;
			}
			.menu li a:before {
				content: '  ';
				width: 60px;
				position: absolute;
				border-bottom: 8px solid #313131;
				bottom: 0;
				right: 350px;
				transition: 0.7s all;
			}
			.menu li a:hover:before {
				right: 0;
			}
		</style>
</head>
<body>
	
   		<div id="userinfo">     
   		<span>欢迎你： ${chrName} </span>
   		<a href="servlet/LogoutController">【安全退出】</a>
   	    </div>
   	  
	<ul class="menu">
		<li><a href="#">首页</a></li>
		<li><a href=download.jsp>下载</a></li>
		<li><a href="#">增加</a></li>
		<li><a href="#">查询</a></li>
		<li><a href="SocialMediaButtons.html">关于</a></li>
	</ul>
</body>
</html>