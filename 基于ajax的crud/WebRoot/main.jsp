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
<title>主界面例</title>
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
 
<script src="https://cdn.jsdelivr.net/npm/live2d-widget@3.0.4/lib/L2Dwidget.min.js"></script>
	<script type="text/javascript">
	L2Dwidget.init();
</script>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ol class="breadcrumb">
	  <li><a href="main.jsp">首页</a></li>
	  <li><a href="Down.jsp">资源下载</a></li>
	  <li><a href="resourceManage.jsp">资源管理</a></li>
	  <li><a href="userManage.jsp">用户管理</a></li>
	  <li><a href="user.jsp">个人中心</a></li>
	  <li><a href="SocialMediaButtons.html">关于</a></li>
	  <li><a href="GetDownloadListController">测试</a></li>
	  
	</ol>
		
	
   		<div id="userinfo">     
   		<span>欢迎你： ${chrName} </span>
   		<a href="logout.do">【安全退出】</a>
   	    </div>
		
		<div class="jumbotron">
		  <h1>Hello, world!</h1>
		  <p>...</p>
		  <p><a class="btn btn-primary btn-lg" href="" role="button">Learn more</a></p>
		</div>
   	  
	
</body>
</html>