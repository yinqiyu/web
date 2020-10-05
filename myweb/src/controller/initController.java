package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DownloadDao;

/**
 * Servlet implementation class initController
 */
@WebServlet("/initDownload.do")
public class initController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		DownloadDao dao = new DownloadDao();
	  Map<String, Object> resultMap = dao.get(null);
	  String resultStr = resultMap.get("image").toString()+","+resultMap.get("path").toString()+","+resultMap.get("size").toString();
			  System.out.println(resultMap.toString());
	  request.setCharacterEncoding("utf-8");  // 设置request字符编码
      String searchText = request.getParameter("search"); // 获取传入的search字段的内容
      response.setContentType("text/json; charset=utf-8");    // 设置response的编码及格式
      PrintWriter out = response.getWriter();
      out.print(resultStr);
	}



}
