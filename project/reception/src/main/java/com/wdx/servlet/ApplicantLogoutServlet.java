package com.wdx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.wdx.domain.Applicant;

/**
 * Servlet implementation class ApplicantLogoutServlet
 */
@WebServlet("/ApplicantLogoutServlet")
public class ApplicantLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicantLogoutServlet() {
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
		String type = request.getParameter("type");
		if(type == null || "".equals(type)) {
			// 获得用户会话，使其失效
			request.getSession().invalidate();
			// 重定向到首页
			response.sendRedirect("index.jsp");
		}else if("find".equals(type)) {
			response.setHeader("content-Type","text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
			Applicant applicant = (Applicant)session.getAttribute("SESSION_APPLICANT");
			Gson gson = new Gson();
			String data = gson.toJson(applicant);
			out.print(data);
		}
	}

}
