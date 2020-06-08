package com.wdx.manager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 设置响应文档类型和编码
				response.setContentType("text/plain;charset=UTF-8");
				PrintWriter out = response.getWriter();
				// 获取请求操作类型
				String type = request.getParameter("type");
				if("companyNameList".equals(type)){
					// 获取企业标识和名称
					CompanyDAO dao = new CompanyDAO();
					ArrayList<Company> companylist = dao.getAllCompanyName();
					Gson gson = new Gson();
					String List = gson.toJson(companylist);
					out.print(List);
				}else if("jobNameList".equals(type)){
					// 获取职位标识和名称
					int companyId = 
						Integer.parseInt(request.getParameter("companyId")==null?"0"
						:request.getParameter("companyId"));
					JobDAO dao = new JobDAO();
					ArrayList<Job> joblist = dao.selectJobNameByCompany(companyId);
					Gson gson = new Gson();
					String List = gson.toJson(joblist);
					out.print(List);
				}else if("query".equals(type)){
					// 根据查询条件进行职位申请信息查询
					String companyId = request.getParameter("companyId");
					String jobId = request.getParameter("jobId");
					String startDate = request.getParameter("startDate");
					String endDate = request.getParameter("endDate");
					JobApplyDao dao = new JobApplyDao();
					ArrayList<JobApply> applylist =
						dao.query(companyId,jobId,startDate,endDate);
					Gson gson = new Gson();
					String List = gson.toJson(applylist);
					out.print(List);
				}
	}

}
