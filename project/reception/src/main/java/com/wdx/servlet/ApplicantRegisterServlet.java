package com.wdx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wdx.dao.ApplicantDAO;

/**
 * Servlet implementation class ApplicantRegisterServlet
 */
@WebServlet("/ApplicantRegisterServlet")
public class ApplicantRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicantRegisterServlet() {
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
		String type = request.getParameter("type");
		// 获取请求参数
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		// 获取用户提交的验证码
		String validateCode = request.getParameter("validateCode");
		// 获取本次请求会话中保存的验证码
		String sessionValidateCode = (String)request.getSession().getAttribute("SESSION_VALIDATECODE");
		// 判断邮箱是否已经被注册
		if("emailAjaxValidate".equals(type)) {
			ApplicantDAO dao = new ApplicantDAO();
			boolean jug = dao.isExistEmail(email);
			if(jug) {
				out.print("邮箱已被注册");
			}else {
				out.print("邮箱可以使用！");
			}
		}else {
			ApplicantDAO applicantDao = new ApplicantDAO();
			if (!validateCode.equals(sessionValidateCode)) {
				out.print("<script>");
				out.print("alert('验证码输入错误');");
				out.print("window.location='./register.html';");
				out.print("</script>");
			}
			boolean flag = applicantDao.isExistEmail(email);
			if(flag) {
					out.print("<script>");
					out.print("alert('邮箱已被注册，请重新输入！');");
					out.print("window.location='register.html';");
					out.print("</script>");
			}else {
				applicantDao.save(email, password);
				// 注册成功，重定向到登录页面
				out.print("<script>");
				out.print("alert('注册成功！');");
				out.print("window.location='login.jsp';");
				out.print("</script>");
			}	
		}
	}

}
