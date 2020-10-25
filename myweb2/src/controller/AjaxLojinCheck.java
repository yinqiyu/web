package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dao.UserDao;
import vo.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class AjaxLojinCheck
 */
@WebServlet("/ajaxLojinCheck.do")
public class AjaxLojinCheck extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//设置参数
		request.setCharacterEncoding("utf-8");
		//1.按照表单的各个元素name抒情值请求参数值
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String vcode = request.getParameter("vcode");
		String autoLogin = request.getParameter("autoLogin");
		
		//2.获取session对象
		HttpSession session = request.getSession();
		//取出验证码字符串
		String saveVode = (String)session.getAttribute("verifyCode");
		//存放返回值信息的map
		Map<String,Object> map =new HashMap<String, Object>();	
		
		//比较输入验证码和随机
		if (!vcode.equalsIgnoreCase(saveVode)){
		      map.put("code",1);
		      map.put("info","验证码不正确");
		}else {//验证码正确
	    	UserDao userDao = new UserDao();
	    	User user = userDao.get(userName);
	    	if (user == null) {//用户名不存在
	    		map.put("code",2);
			    map.put("info","用户名不存在");
	    	}else {//用户名存在		
	    		if(!user.getPassword().equals(password)) {//密码不对
	    		map.put("code",3);
				map.put("info","密码不正确");
	    	}else {
				//传参数到session中
	    		session.setAttribute("currentUser", user);
	    		if(autoLogin != null)
	    		{
	    			//设置cookie
	    			Cookie cookie1 = new Cookie("userName", userName);
	    			cookie1.setMaxAge(7 * 24 *24 *24);//七天
	    			response.addCookie(cookie1);
	    			Cookie cookie2 = new Cookie("password", password);
	    			cookie2.setMaxAge(7 * 24 *24 *24);//七天
	    			response.addCookie(cookie2);
	    		}
	    		map.put("code", 0);
	    		map.put("info","登录成功");
			}
		
	    	}

		}
		String jsonStr =new Gson().toJson(map);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		out.print(jsonStr);
		out.flush();
		out.close();
	}
}
