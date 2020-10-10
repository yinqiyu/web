package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import vo.User;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(urlPatterns ="/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//编码格式
		request.setCharacterEncoding("utf-8");
		//获取
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		String chrName = request.getParameter("chrName");
		String vcode = request.getParameter("vcode");
		//获取session对象
	    HttpSession session = request.getSession();
	    
	    String saveVode = (String)session.getAttribute("verifyCode");
	    String forwardpath = "";
	    
	    if (!vcode.equalsIgnoreCase(saveVode)){
	      request.setAttribute("info", "验证码不正确");
	      forwardpath = "/error.jsp";	     
	    } else {//验证码正确
	    	UserDao userDao = new UserDao();
	    	if (userDao.get(username) == null) {//用户名不存在
	    		request.setAttribute("info", "您输入的用户名不存在！");
	    		forwardpath = "/error.jsp";
	    	}else {//用户名存在
	    		User currentUser = userDao.get(username);
	    		if(currentUser == null) {//密码不对
		    		request.setAttribute("info", "您输入的密码不正确！");
		    		forwardpath = "/error.jsp";
	    		}else {
	    			
	    			session.setAttribute("currentUser",currentUser);
	    			forwardpath = "/main.jsp";
	    			session.setAttribute("chrName",User.getChrName());
	    		}
	    	}
	    }
	    RequestDispatcher rd = request.getRequestDispatcher(forwardpath);
	    rd.forward(request, response);
	}	
}
