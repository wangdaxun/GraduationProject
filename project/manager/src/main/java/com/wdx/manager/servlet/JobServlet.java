package com.wdx.manager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wdx.manager.bean.Company;
import com.wdx.manager.bean.Job;
import com.wdx.manager.bean.JobApply;
import com.wdx.manager.dao.CompanyDAO;
import com.wdx.manager.dao.JobApplyDao;
import com.wdx.manager.dao.JobDAO;


/**
 * Servlet implementation class JobServlet
 */
@WebServlet("/JobServlet")
public class JobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("content-Type", "text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 获取请求操作类型
		String type = request.getParameter("type");
		// 创建职位和企业DAO对象
		JobDAO jobDao = new JobDAO();
		CompanyDAO companyDao = new CompanyDAO();
		JobApplyDao applyDao = new JobApplyDao();
		if("list".equals(type)) {
			// 获得所有职位信息
			ArrayList<Job> joblist = jobDao.selectAll();
			ArrayList<Company> companyList = companyDao.getAllCompanyName();
			Map<String,Object> map = new HashMap<>();
			map.put("joblist", joblist);
			map.put("companylist",companyList);
			Gson gson = new Gson();
			String json = gson.toJson(map);
			out.print(json);
			//out.print(Company);
		}else if("query".equals(type)){
			int companyId = Integer.parseInt(request.getParameter("companyId"));
			String jobName = request.getParameter("jobName");
			ArrayList<Job> joblist = jobDao.query(companyId,jobName);
			ArrayList<Company> companylist = companyDao.getAllCompanyName();
			Map<String,Object> map = new HashMap<>();
			map.put("joblist", joblist);
			map.put("companylist",companylist);
			Gson gson = new Gson();
			String json = gson.toJson(map);
			out.print(json);
		}else if("jobApply".equals(type)){
			ArrayList<JobApply> jobApplyList = applyDao.getJobApply();
			Gson gson = new Gson();
			Map<String, Object> map = new HashMap<>();
			map.put("jobApplyList", jobApplyList);
			out.print(gson.toJson(map));
		}
	}

}
