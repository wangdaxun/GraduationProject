package com.wdx.manager.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthorityFilter
 */
@WebFilter(
	urlPatterns = {"/manage/*"},
	servletNames = {"com.wdx.manager.servlet.CompanyAddServlet",
			"com.wdx.manager.servlet.CompanyServlet",
			"com.wdx.manager.servlet.ResumeServlet",
			"com.wdx.manager.servlet.UserAddServlet",
			"com.wdx.manager.servlet.UserServlet"},
	initParams = { @WebInitParam(name="loginPage",value="login.html")}
)
public class AuthorityFilter implements Filter {

	private String loginPage;

    /**
     * Default constructor.
     */
    public AuthorityFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		this.loginPage = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		// 判断如果是登陆请求则放行
		if("/UserServlet".equals(req.getServletPath()) &&
				"type=login".equals(req.getQueryString())) {
			// pass the request along the filter chain
			chain.doFilter(request, response);
			return;
		}
		// 判断被拦截的请求用户是否处于登陆状态，若未登陆，返回登录页面
		if(session.getAttribute("SESSION_USER") == null) {
			resp.sendRedirect(req.getContextPath() + "/" + loginPage);
		}else {
			chain.doFilter(request, response);
			return;
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		loginPage = fConfig.getInitParameter("loginPage");
		if (null == loginPage) {
			loginPage = "login.html";
		}
	}

}
