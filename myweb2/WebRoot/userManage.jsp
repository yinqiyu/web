<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!--这个lang="zh-CN"是转化为html5的版本  -->
<html lang="zh-CN">
<head>
<base href="<%=basePath%>">
<title>学习bootstrap案例</title>
<!-- 这个是自适应各种分辨率的屏幕 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
 
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet"  href="css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/style.css"/>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
 
</head>
<body>
<!-- 导航 -->
	<nav class="navbar navbar-default">
	<div class="container-fluid">	
		<ul class="nav navbar-nav">
			<li class="active"><a href=""></a></li>
			<li><a href="main.jsp">首页</a></li>
			<li><a href="">关于</a></li>
			<li><a href="">登录</a></li>
		</ul>		
		</div>
	</nav>
<button class="btn-primary">按钮</button>
<button type="button" class="btn btn-default btn-lg">
  <span class="glyphicon glyphicon-star" aria-hidden="true"></span> Star
</button>

<div>
</div>
<table class="table table-hover">
<!-- On rows -->
<tr class="active">...</tr>
<tr class="success">...</tr>
<tr class="warning">...</tr>
<tr class="danger">...</tr>
<tr class="info">...</tr>

<!-- On cells (`td` or `th`) -->
<tr>
  <td class="active">...</td>
  <td class="success">...</td>
  <td class="warning">...</td>
  <td class="danger">...</td>
  <td class="info">...</td>
</tr>
</table>
</body>
</html>