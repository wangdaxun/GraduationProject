package com.wdx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import com.wdx.dao.ResumeDAO;
import com.wdx.domain.Applicant;
import com.wdx.domain.ResumeBasicinfo;

/**
 * Servlet implementation class ResumeBasicinfoServlet
 */
@WebServlet("/ResumeBasicinfoServlet")
public class ResumeBasicinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResumeBasicinfoServlet() {
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
		// 获取请求操作类型
		String type = request.getParameter("type");
		// 简历添加操作
		if("add".equals(type)) {
			// 封装请求数据
			ResumeBasicinfo basicinfo = this.requestDataObj(request);
			// 从会话对象中获取当前登录用户标识
			Applicant applicant = (Applicant)request.getSession().getAttribute("SESSION_APPLICANT");
			// 将数据存储到数据库
			ResumeDAO resumeDao = new ResumeDAO();
			int basicfoID = resumeDao.add(basicinfo, applicant.getApplicantId());
			// 将简历标识存入会话对象中
			request.getSession().setAttribute("SESSION_RESUMEID", basicfoID);
			// 操作成功，跳回“我的简历”页面
			response.sendRedirect("applicant/resume.html");
		}else if("select".equals(type) || "updateSelect".equals(type)) {
			Applicant applicant = (Applicant)request.getSession().getAttribute("SESSION_APPLICANT");
			// 根据用户标识查询简历基本信息
			ResumeDAO resumeDao = new ResumeDAO();
			ResumeBasicinfo basicinfo = resumeDao.selectBasicinfoById(applicant.getApplicantId());
			Gson gson = new Gson();
			String data = gson.toJson(basicinfo);
			out.print(data);
		}else if("update".equals(type)) {
			ResumeBasicinfo resume = requestDataObj(request);
			Applicant applicant = (Applicant)request.getSession().getAttribute("SESSION_APPLICANT");
			resume.setBasicinfoId(applicant.getApplicantId());
			ResumeDAO resumeDao = new ResumeDAO();
			int result = resumeDao.update(resume);
			System.out.println(result);
			if(result != 0) {
				out.print("<script>");
				out.print("alert('修改成功！');");
				out.print("window.location='index.jsp';");
				out.print("</script>");
			} else {
				out.print("<script>");
				out.print("alert('修改失败！');");
				out.print("window.location='./applicant/resume.html';");
				out.print("</script>");
			}
		}
	}
	private ResumeBasicinfo requestDataObj(HttpServletRequest request) {
		ResumeBasicinfo basicinfo = null;
		// 获得请求数据
		String realName = request.getParameter("realName");
		String gender = request.getParameter("gender");
		//String birthday = request.getParameter("birthday");
		String currentLoc = request.getParameter("currentLoc");
		String residentLoc = request.getParameter("residentLoc");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		String jobIntension = request.getParameter("jobIntension");
		String jobExperience = request.getParameter("jobExperience");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthdayDate = null;
//		try {
//			birthdayDate = sdf.parse(birthday);
//		}catch(ParseException e) {
//			birthdayDate = null;
//		}
		// 将请求数据封装成一个简历基本信息对象
		basicinfo = new ResumeBasicinfo(new Timestamp(new Date().getTime()), currentLoc, email, 
				gender, "jwn.jpg", jobExperience, jobIntension, realName, residentLoc, telephone);
		return basicinfo;
		
	}
	

}
