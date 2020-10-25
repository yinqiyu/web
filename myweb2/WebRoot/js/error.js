var i = 10;
		        var intervalid;
		        intervalid = setInterval("fun()", 1000);
		        function fun() {
		            if (i == 0) {
		                window.location.href = "login.html";
		                clearInterval(intervalid);
		            }
		            document.getElementById("mes").innerHTML = i;
		            i--;
		        }