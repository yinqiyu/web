package filter;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.LifecycleListener;

import com.mysql.fabric.xmlrpc.base.Array;
import com.sun.org.apache.xerces.internal.impl.dv.SchemaDVFactory;

import dao.resourceDao;
import jdk.nashorn.internal.ir.Flags;
import vo.User;
import vo.resource;

public class PermissionFilter implements Filter {  //过滤器实现接口

	
	private String notCheckPath;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//类型转换
		HttpServletRequest request = (HttpServletRequest) req;
		String path = request.getServletPath();//获取请求的地址
		User user = null;
		int flag = 0;
		List<resource> resources =  new ArrayList<resource>();
		System.out.println("请求地址url-pattern：" + path);
		//请求地址不需要再过滤列表范围内，需要判断是否已经登录
		if (notCheckPath.indexOf(path) == -1) {
			HttpSession session = request.getSession();
			user = (User)session.getAttribute("currentUser");
			//System.out.println(user.toString());
			if (user == null) {
				request.setAttribute("info", "没有权限访问");
				request.getRequestDispatcher("/error.jsp").forward(request, resp);
			}
			else {
				user = (User)session.getAttribute("currentUser");
				resources = resourceDao.get(user.getUserName());
				System.out.println("url"+resources.size());
				for (int i = 0; i < resources.size(); i++) {
					System.out.println("url"+resources.get(i).getUrl());
					if (resources.get(i).getUrl().equals(path)) {
						flag = 1;
					}
				}
			}
			if (flag == 1) {
				chain.doFilter(req, resp);
				flag = 0;
			} else {
				request.setAttribute("info", "没有权限访问");
				request.getRequestDispatcher("/error.jsp").forward(req, resp);

			}
		}else {//请求地址是不需要过滤的
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		notCheckPath = config.getInitParameter("notCheckUri");

	}

}
