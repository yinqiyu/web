<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="vo.User" %>


<!DOCTYPE html>
<html>
<head>
<head>
    
    <title>My JSP 'dwonload.jsp' starting page</title>
    <script type="text/javascript">  
 
  loadXMLDoc();
  function loadXMLDoc(){
   var xmlhttp;
   if (window.XMLHttpRequest){
    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
    xmlhttp=new XMLHttpRequest();
   }
   else{
    // IE6, IE5 浏览器执行代码
    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
   }
   xmlhttp.onreadystatechange=function(){
    if (xmlhttp.readyState==4 && xmlhttp.status==200){
     var s = xmlhttp.responseText;
    var urls = s.split(",");
     document.getElementById("imgSrc").src ="/test"+urls[0];
     document.getElementById("size").innerHTML=urls[2];
     
    }
   }
   xmlhttp.open("GET","/test/initDownload.do",true);
   xmlhttp.send();
  }
 </script>


	<style>
		*{
			margin: 0;
			padding: 0;
		}
		a{
			text-decoration: none;
		}
				#head{
					height: 120px;
					width: 100%;
				}
				#logo{
					float: left;
					height: 200px;
					width: 200px;
				}
				#userinfo{
					font-size: 18px;
					float:right;
					height: 30px;
					width: 300px;
				}
				#daohang{
				}
				li{
					float: right;
					list-style: none; 
					margin-right: 20px;
					font-size: 30px;
				}
				}
				a{
					text-decoration: none;
				}
				#content{
					margin: 0 auto;
					width: 800px;
					height: 800px;
					background-color: white;
				}
				.fileimage{
					width: 120px;
					height: 120px;
					margin: 5px;
				}
				.fileleft{
					float: left;
					height: 220px;
					width: 130px;
				}
				.fileright{
					width: 800px;
					height: 220px;
				}
				.smallsize{
					font-size: 14px;
					color: gray;
				}
				.filedescription{
	
				}
				.button{
					float: right;
					color: #68D69D;
					border: 2px solid #68D69D;
					width: 150px;
					height: 35px;
					font-size: 24px;
					text-align: center;
					margin: 5px;
				}
				.filetitle{
					font-size: 38px;
				}
				.smallstar{
					height: 18px;
					width: 90px;

				}
				#content ul li{
					margin-bottom: 15px;
				}
			</style>
  </head>
</head>
<body>
<div id="userinfo">     
   		<span>欢迎你： ${chrName} 
  	
  		</span><a href="login.html">【安全退出】</a>
   		</div>
	<h1>资源下载</h1>
	<div id="content"> 
  		<ul style="float:left;">
			<c:forEach items="${dlist}" var="Download" varStatus="index">
  			<li>
  				<div class="fileleft"><img id="imgSrc" class="fileimage" src="images/${Download.image}"/></div>
  				<div class="fileright">
  					<span class="filetitle">&nbsp;&nbsp;${Download.name } </span>
  					<div></div>
  					<i class="smallsize" id="size">&nbsp;大小：</span>&nbsp;&nbsp;&nbsp;</i>
  					<span class="smallsize">&nbsp;时间：2020-10-01 </span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  					<span class="smallsize">&nbsp;星级：<img class="smallstar" src="images/${Download.star}star.png"/>
					</span>&nbsp;&nbsp;&nbsp;<br/>
  					<span class="filedescription">${Download.description }</span>
  				  	<a href="http://localhost:8080/test/DownloadContext/第1部分通信基础2.ppt">【下载】</a>
  				
  			<hr style="height:1px;border:none;border-top:2px solid rgb(235,235,235); margin-left: 75px;" width="650px"  /> 
  			
  			</li>
			</c:forEach>
  		</ul>
  		
		
   </div>
		
	</div>
	
</body>
</html>