package com.wdx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.wdx.dao.ApplicantDAO;
import com.wdx.domain.Applicant;
import com.wdx.util.CookieEncryptTool;

/**
 * Servlet implementation class ApplicantLoginServlet
 */
@WebServlet("/ApplicantLoginServlet")
public class ApplicantLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicantLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("content-Type","text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 获取请求参数
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("rememberMe");
		String requestPath = request.getParameter("requestPath");
		// 登录验证
		ApplicantDAO applicantDAO = new ApplicantDAO();
		int applicantID = applicantDAO.login(email, password);
		if(applicantID != 0) {
			// 用户登录成功，将求职者信息存入会话对象
			Applicant applicant = new Applicant(applicantID, email, password);
			request.getSession().setAttribute("SESSION_APPLICANT", applicant);
			// 通过Cookie记住邮箱和密码
			rememberMe(rememberMe, email, password, request, response);
			// 判断是否已存在请求路径
			if(!"".equals(requestPath) && null != requestPath) {
				response.sendRedirect(requestPath);
			}else {
				// 判断是否已有简历
				int resumeID = applicantDAO.isExistResume(applicantID);
				if(resumeID != 0) {
					// 若简历已存在，将简历标识存入会话对象并跳到首页
					request.getSession().setAttribute("SESSION_RESUMEID", applicant);
					response.sendRedirect("index.html");
				}else {
					// 若简历不存在，跳到简历填写向导页面
					response.sendRedirect("applicant/resumeGuide.html");
				}	
			}
		}else {
			// 用户登录信息错误，进行错误提示
			out.print("<script>");
			out.print("alert('用户名或密码错误，请重新输入！');");
			out.print("window.location='login.html';");
			out.print("</script>");
		}
	}
	private void rememberMe(String rememberMe, String email, String password, 
			HttpServletRequest request, HttpServletResponse response) {
		// 判断是否需要通过Cookie记住邮箱和密码
		if("true".equals(rememberMe)) {
			// 记住邮箱及密码
			Cookie cookie = new Cookie("COOKIE_APPLICANTEMAIL", CookieEncryptTool.encodeBase64(email));
			cookie.setPath("/");
			cookie.setMaxAge(365 * 24 * 3600);
			response.addCookie(cookie);
			cookie = new Cookie("COOKIE_APPLICANTPWD", CookieEncryptTool.encodeBase64(password));
			cookie.setPath("/");
			cookie.setMaxAge(365 * 24 * 3600);
			response.addCookie(cookie);
		} else {
			// 	将邮箱及密码Cookie删除
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if("COOKIE_APPLICANTEMAIL".equals(cookie.getName())
				|| "COOKIE_APPLICANTPWD".equals(cookie.getName())) {
						cookie.setMaxAge(0);
						cookie.setPath("/");
						response.addCookie(cookie);
					}
				}
			}
		}
	}
}
