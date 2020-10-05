package controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CreatImage;

import java.io.PrintWriter;

@WebServlet(urlPatterns = "/creatVerifyImage.do")
public class CreateVerfifyCodeImageServlet extends HttpServlet {
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//把验证码图片生成的过程封装在
		CreatImage creatImage = new CreatImage();
			//产生随机数
			String vCode = creatImage.createCode();
			//获取对象
			HttpSession session = request.getSession();
			//将产生的字符串放入session中，以便于验证
			session.setAttribute("verifyCode", vCode);
			//设置返回内容
			response.setContentType("img/jpeg");
			//浏览器不缓存相应内容--验证码图片，点一次就刷新一次，所以不能有缓存出现
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-control", "no-cache");
			//设置验证码失效时间
			response.setDateHeader("Expires", 0);
			//以字节流发过去交给img的src属性解析即可
			BufferedImage image = creatImage.CreateImage(vCode);
			ServletOutputStream out = response.getOutputStream();
			ImageIO.write(image,"JPEG",out);
			out.flush();
			out.close();
			
			
		
	}

}
