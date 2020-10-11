package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/logout.do")
public class LogoutController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookiename=new Cookie("cookiename",null);
		Cookie cookiepwd=new Cookie("cookiepwd",null);
		cookiename.setMaxAge(0);
		cookiepwd.setMaxAge(0);
		cookiepwd.setPath("/");
		cookiename.setPath("/");
		response.addCookie(cookiename);
		response.addCookie(cookiepwd);
		response.setContentType("text/html;charset=UTF-8");
		request.getSession().removeAttribute("currentuser");
		response.sendRedirect("/test/login.html");
		
	}


}
