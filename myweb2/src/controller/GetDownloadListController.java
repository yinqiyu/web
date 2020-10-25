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

import dao.DownloadDao;
import sun.security.util.Length;
import vo.Download;
@WebServlet(urlPatterns = "/download.do")

public class GetDownloadListController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String fileName = request.getParameter("filename");
		//下载问价俩参数
		response.addHeader("contentType","application/octet-stream");//mime类型
		response.addHeader("contentType-Disposition","attachement;filename="+fileName);//包含了文件后缀：abc.txt
		
		//servlet通过地址 将该文件转为输入流
		InputStream in = getServletContext().getResourceAsStream("/WEB-INF/files/java.docx");
		
		//转换输出流
		ServletOutputStream out = response.getOutputStream();
		byte[] bs = new byte[1024];
		int len = -1;
		while (   (len = in.read(bs)) != -1) {
			//将缓冲区的数据输出给客户端
		out.write(bs,0,len);
		}
		out.close();
		in.close();

		
		
		
	}
}
					
//	String id = request.getParameter("id");
//	DownloadDao dao = new DownloadDao();
//	Download download = dao.get(Integer.parseInt(id));
//		
//	
//	//1.获取下载文件的绝对路径
//	String path = request.getServletContext().getRealPath("/WEB-INF/"+download.getPath());
//	
//	//2.获取下载的文件名
//	String filename = path.substring(path.lastIndexOf("\\")+1);
//	
//	//3.设置响应头
//	response.setHeader("content-disposition","attachment;filename="+URLEncoder.encode(filename,"UTF-8"));
//	
//	//4.输入流
//	InputStream in = new FileInputStream(path);
//	int len = 0;
//	
//	//5.创建缓冲区域
//	byte[] buffer = new byte[1024];
//	//6.获取output
//	ServletOutputStream out = response.getOutputStream();
//	
//	//7.写入缓冲区
//	while ((len = in.read(buffer)) != -1) {
//		//将缓冲区的数据输出给客户端
//		out.write(buffer,0,len);
//	}
//	in.close();
//	out.close();
//	}
//	
