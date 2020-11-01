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
<title>用户管理</title>
<!-- 这个是自适应各种分辨率的屏幕 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
 
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet"  href="css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/style.css"/>
<link rel="stylesheet" type="text/css" href="css/table css_table.css">
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
 
</head>
<body>
<!-- 导航栏 -->
 <ol class="breadcrumb">
	  <li><a href="main.jsp">首页</a></li>
	  <li><a href="Down.jsp">资源下载</a></li>
	  <li><a href="resourceManage.jsp">资源管理</a></li>
	  <li><a href="userManage.jsp">用户管理</a></li>
	  <li><a href="user.jsp">个人中心</a></li>
	  <li><a href="SocialMediaButtons.html">关于</a></li>
    <li><a href="GetDownloadListController">测试</a></li>
    <li class="register">注册</li> 
</ol>
  <div id = "pagageBody" class="pageBody">
    <div id = "serchForm" class="serchForm">
      <form id = "serchForm" class="serchForm">
        <input type="text" name="userName" placeholder="输入用户名"/>
        <input type="text" name="chrName" placeholder="输入姓名"/>
        <input type="text" name="mail" placeholder="输入邮箱地址"/>
        <input type="text" name="provinceNmae" placeholder="输入省份"/>
      </form>
    </div>

    <div id="bt" class="bt">
      <a href="#" id="btSearch" class="my_link_button">
        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查找
        </a>
        <a href="#" id="btSearch" class="my_link_button">
        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>清空
        </a>
        <a href="#" id="btSearch" class="my_link_button">
        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加
        </a>
        <a href="#" id="btSearch" class="my_link_button">
        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除
        </a>
        <a href="#" id="btSearch" class="my_link_button">
        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
        </a>
    </div>
  </div>
  
  <table  class="table css_table">
    <thead>
      <th width="40"><input type="checkbox" id=“ckAll” title="选择"/></th>
      <th class="bg" id="sortByUserName">用户名</th>
      <th width="110">中文名</th>
      <th>邮箱</th>
      <th width="70" class="bg" id="sortByProvinceName" data="provinceNmae">省份</th>
      <th width="70">城市</th>
      <th width = "120">操作</th>
    </thead>
    <tr>
      <td>January</td>
      <td>$100</td>
      <td>January</td>
      <td>$100</td>
      <td>January</td>
      <td>$100</td>
    </tr>
    <tr>
      <td>January</td>
      <td>$100</td>
      <td>January</td>
      <td>$100</td>
      <td>January</td>
      <td>$100</td>
    </tr>
    <tr>
      <td>January</td>
      <td>$100</td>
      <td>January</td>
      <td>$100</td>
      <td>January</td>
      <td>$100</td>
    </tr>
  </table>

  <div class="paging">
    <div>
      <select>
        <option>5</option>
        <option selected>10</option>
        <option>20</option>
      </select>,共
      <span id="total"></span>条数据，
      <span id="pageNumber">1</span>页<span id="pagageCount"></span>页
    </div>
    <div class="pageNave">
      <a id="first" href="#">首页</a>
      <a id="back" href="#">上一页</a>
      <a id="next" href="#">下一页</a>
      <a id="last" href="#">尾页</a>
    </div>
  </div>

</body>
</html>