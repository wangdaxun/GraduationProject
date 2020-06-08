package com.wdx.manager.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import com.google.gson.Gson;
import com.wdx.manager.bean.Company;
import com.wdx.manager.dao.CompanyDAO;


/**
 * Servlet implementation class CompanyServlet
 */
@MultipartConfig
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
		response.setHeader("content-Type","text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		CompanyDAO companyDao = new CompanyDAO();
		Gson gson = new Gson();
		if("list".equals(type)) {
			// 显示所有数据库里有的公司
			ArrayList<Company> companys = new ArrayList<Company>();
			companys = companyDao.getAll();
			String companyList = gson.toJson(companys);
			out.print(companyList);
			//response.sendRedirect("manage/companyList.html");
		}else if("updateSelect".equals(type)) {
			// 根据id找一个公司
			Integer id = Integer.parseInt(request.getParameter("companyId"));
			Company company = new Company();
			company = companyDao.getOne(id);
			String TheCompany = gson.toJson(company);
			out.print(TheCompany);
		}else if("update".equals(type)) {
			// 根据传过来的id修改公司里的信息
			Integer id = Integer.parseInt(request.getParameter("companyId"));
			// 解析request
			String company_name = request.getParameter("companyName");
			String company_area = request.getParameter("companyArea");
			String company_size = request.getParameter("companySize");
			String company_type = request.getParameter("companyType");
			String company_desc = request.getParameter("companyDesc");
			Integer company_state = Integer.parseInt(request.getParameter("companyState"));
			Integer company_sort = Integer.parseInt(request.getParameter("companySort"));
			String newFileName = new String();
			Company company = new Company(company_name, company_area, company_size, company_type, company_desc, company_state, company_sort, 0, newFileName);
			company.setCompanyId(id);
			companyDao.update(company);
			out.print("<script>");
			out.print("alert('企业信息修改成功');");
			out.print("window.location='manage/companyList.html';");
			out.print("</script>");
		}
	}

}
