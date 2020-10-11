package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.LoginController;
import tools.CookieUtil;

/**
 * Servlet Filter implementation class AutoLoginFilter
 */
@WebFilter("/AutoLoginFilter")
public class loginFilter implements Filter {
	private String notCheckPath;

    /**
     * Default constructor. 
     */
    public loginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        if(request.getRequestURI().contains("login")) {//如果访问login,直接放行
            chain.doFilter(request, response);
            return;
        }else {
            String username = (String) request.getSession().getAttribute("username");
            if(username==null) {//sesion中没有，去Cookie中找
                String val = CookieUtil.getCookieValByKey("auto", request);
                if(val!= null&& !val.equals("")) {
                    String name = val.split("_")[0];
                    String pass = val.split("_")[1];

                    if(new LoginController().equals(name)) {//重新验证登录
                        request.getSession().setAttribute("username", name);//登录成功，放入Session，并放行
                        chain.doFilter(request, response);
                        return;
                    }else {//验证失败，重新登录
                        response.sendRedirect("login.jsp");
                    }
                }else {//Cookie中也没有，第一次访问，跳转登录页面
                    response.sendRedirect("login.jsp");
                }
            }else {//session中有，放行
                chain.doFilter(request, response);
                return;
            }
        }
    }


	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		notCheckPath = fConfig.getInitParameter("notCheckUrl");
	}

}
