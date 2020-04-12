package com.wdx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wdx.dao.JobApplyDAO;
import com.wdx.domain.Applicant;
import com.wdx.domain.JobApply;

/**
 * Servlet implementation class JobApplyServlet
 */
@WebServlet("/JobApplyServlet")
public class JobApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobApplyServlet() {
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
		response.setHeader("content-Type", "text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		if("apply".equals(type)) {
			int jobid = Integer.parseInt(request.getParameter("id"));
			Applicant applicant =(Applicant)request.getSession().getAttribute("SESSION_APPLICANT");
			JobApplyDAO jobApplyDao = new JobApplyDAO();
			jobApplyDao.save(jobid, applicant.getApplicantId());
			ArrayList<JobApply> jobApplyList = jobApplyDao.getJobApplyList(applicant.getApplicantId());
			Gson gson = new Gson();
			String data = gson.toJson(jobApplyList);
			out.print(data);
		}
	}
}
