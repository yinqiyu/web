/*function changeImg(){
	document.getElementById("vcodeImg").src = "creatVerifyImage.do?t=" + Math.random();
	}
*/



var xmlHttp;
function creatXmlHttp(){
	if (window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
}

/**
 * 使用原生js实现ajax登录
 */
function ajaxCheckLogin(){
//获取表单数据
	var userName = document.getElementById("userName").Value;
	var password = document.getElementById("password").Value;
	var vcode = document.getElementById("vcode").Value;
	var autoLogin = document.getElementById("autoLogin").Value;
}
creatXmlHttp();//调用自定义的函数创建httprequest对象
xmlHttp.open();
xmlHttp.setRequestHeader("Content-Type","application/X-WWW-form-urlencoded");
xmlHttp.send("userName" + userName + "&password" + password + "&vcode" + vcode +"&autoLogin" + autoLogin);
xmlHttp.onreadysyayechange = function(){  //回调函数 接受服务器返回及处理
	if (xmlHttp.readyState = 4 && xmlHttp.status == 200) {
		var response = xmlHttp.responseTex;
		var json = JSON.parse(response);//调用系统函数将字符串转为json对象
		if (json.code == 0) {
			window.location.href = "main.jsp";
		}else{
			document.getElementById("checkError").innerText = json.info;
		}
		
	}
}

/**
 * 使用jQuery实现基于ajax的用户登录
 */

 function jqAjaxChecLojin(){
	$.ajax({
		type:"post",
		url:"ajaxLojinCheck,do",
		data:{userName:$("#userName").val(),password:$("#password").val(),vcode:$("#vcode").val()},
		dataType:"json",
		success:function(response){
			if(response.code == 0){
				window.location.href = "main.jsp";
			}else{
				$("#checkErro").tex(response.info);
			}
		}
	});
 }

$(document).ready(function() {
	    $("#userName").blur(function(e) {
	        if ($(this).val() == "") {
	            $("#userNameError").text("用户名不能为空");
	        } else {
	            $("#userNameError").text("");
	            userName_correct = true;
	        }
	    });
	
	    $("#password").blur(function(e) {
	        if ($(this).val() == "") {
	            $("#passwordError").text("密码不能为空");
	        } else {
	            $("#passwordError").text("");
	            password_correct = true;
	        }
	    });
	
	    $("#vcode").blur(function(e) {
	        if ($(this).val() == "") {
	            $("#vcodeError").text("验证码不能为空");
	        } else {
	            $("#vcodeError").text("");
	            vcode_correct = true;
	        }
	    });
	});