package com.wdx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wdx.dao.CompanyDAO;
import com.wdx.dao.JobDAO;
import com.wdx.domain.Company;
import com.wdx.domain.CompanyPageBean;
import com.wdx.domain.Job;


/**
 * Servlet implementation class CompanyServlet
 */
@WebServlet("/CompanyServlet")
public class CompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyServlet() {
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
		response.setHeader("content-Type","text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if("select".equals(type)) {
			int companyId = Integer.parseInt(request.getParameter("id"));
			CompanyDAO companyDao = new CompanyDAO();
			Company company = companyDao.getCompanyById(companyId);
			JobDAO jobDao = new JobDAO();
			ArrayList<Job> jobList = jobDao.getJobListByCompanyId(companyId);
			HashMap<String, Object> hashMap = new HashMap<>();
			hashMap.put("company",company);
			hashMap.put("job", jobList);
			Gson gson = new Gson();
			String data = gson.toJson(hashMap);
			System.out.println(data);
			out.print(data);
		}else if("sel".equals(type)) {
			CompanyDAO companyDao = new CompanyDAO();
			ArrayList<Company> list = companyDao.getCompanyList();
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("Company", list);
			Gson gson = new Gson();
			String data = gson.toJson(hashMap);
			out.print(data);
		}else if("selPage".equals(type)) {
			CompanyPageBean companyPageBean = new CompanyPageBean();
			ArrayList<Company> companyList = new ArrayList<Company>();
			Integer pageSize = null;
			Boolean hasNext = null;
			Boolean hasPrevious = null;
			Integer pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt(request.getParameter("pageNo"));  	
			Integer total = companyPageBean.getTotalPages();
			// 要首先把pageNo,totalPages值给赋到Bean里，才能获取到总页数
			companyPageBean.setPageNo(pageNo);
			companyPageBean.setTotalPages(total);
			companyList = companyPageBean.getPageData();
			System.out.println("111"+companyList.get(0).getCompanyName());
			companyPageBean.setPageData(companyList);
			hasNext = companyPageBean.isHasNext();
			hasPrevious = companyPageBean.isHasPrevious();
			// 将设置好的值传到bean里
			companyPageBean.setHasNext(hasNext);
			companyPageBean.setHasPrevious(hasPrevious);
			companyPageBean.setPageSize(pageSize);
			Gson gson = new Gson();
			String pageData = gson.toJson(companyPageBean);
			out.print(pageData);
		}
	}

}
