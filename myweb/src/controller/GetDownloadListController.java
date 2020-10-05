package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/servlet/download")

public class GetDownloadListController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//编码
		request.setCharacterEncoding("utf-8");
		//获取下载文件的绝对路径

		String  num =request.getParameter("var");
		int a = Integer.parseInt(num);
		String filepath =dao.DownloadDao.dlist.get(a).getPath();
		String path = request.getServletContext().getRealPath((filepath));

		//获取下载的文件名
		String fileName = path.substring(path.lastIndexOf("\\")+1);
		
		//设置响应头
		response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));

		//获取下载的文件输入流
		InputStream in =new FileInputStream(path);
		int len = 0;
		
		//创建数据缓冲区
		byte[] buffer = new byte[1024];
		
		//通过response对象获取output流
		ServletOutputStream out = response.getOutputStream();
		
		//将fileinputstream 写入buffer缓冲
		while((len = in.read(buffer))!= -1){
			out.write(buffer, 0, len);
		}
		//关闭
		in.close();
		out.close();
		
		
	}
	
}
