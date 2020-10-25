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
function ajaxCheckLogin() {
	    if (!userName_correct || !password_correct || !vcode_correct) {
	        $("#userName").blur();
	        $("#password").blur();
	        $("#vcode").blur();
	        return;
	    }
	    var userName = document.getElementById("userName").value;
	    var password = document.getElementById("password").value;
	    var vcode = document.getElementById("vcode").value;
	    var data = "userName=" + userName + "&password=" + password + "&vcode=" + vcode;
	    if (document.getElementById("autoLogin").checked)
	        data = data + "&autoLogin=y";
	    createXmlHttp(); //鐠嬪啰鏁ら懛顏勭暰娑斿鍤遍弫鏉垮灡瀵ょMLHttpRequest鐎电钖�
	    xmlHttp.open("post", "ajaxLoginCheck.do", true);
	    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	    xmlHttp.send(data);
	    xmlHttp.onreadystatechange = function() { //閸ョ偠鐨熼崙鑺ユ殶
	        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
	            var response = xmlHttp.responseText;
	            var json = JSON.parse(response); //鐠嬪啰鏁ょ化鑽ょ埠閸戣姤鏆熺亸鍡楃摟缁楋缚瑕嗘潪顒佸床娑撶皜son鐎电钖�
	            if (json.code == 0) { //閻ц缍嶉幋鎰 
	                window.location.href = "main.jsp";
	            } else { //閻ц缍嶆径杈Е
	                document.getElementById("checkError").innerText = json.info; //閺勫墽銇氭潻鏂挎礀闁挎瑨顕ゆ穱鈩冧紖
	            }
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