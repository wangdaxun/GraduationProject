package com.wdx.manager.servlet;

import com.wdx.manager.bean.Company;
import com.wdx.manager.dao.CompanyDAO;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 * Servlet implementation class companyAddServlet
 */
@MultipartConfig
@WebServlet("/CompanyAddServlet")
public class CompanyAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyAddServlet() {
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
		response.setHeader("content-Type","text/html;charset=utf-8");
		// 解析request
		String company_name = request.getParameter("companyName");
		String company_area = request.getParameter("companyArea");
		String company_size = request.getParameter("companySize");
		String company_type = request.getParameter("companyType");
		String company_desc = request.getParameter("companyDesc");
		Integer company_state = Integer.parseInt(request.getParameter("companyState"));
		Integer company_sort = Integer.parseInt(request.getParameter("companySort"));
		// 获取上传文件域
		Part part = request.getPart("companyPic");
		// 获取上传文件名称
		String fileName = part.getSubmittedFileName();
		// 为防止上传文件重名，对文件进行重命名
		String newFileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
		// 将上传的文件保存在服务器根目录下的upload/companyPic子目录下
		String filepath = getServletContext().getRealPath("/");
		// filepath = filepath.substring(0, filepath.indexOf(getServletContext().getServletContextName()));
		filepath = filepath + "upload/companyPic";
		System.out.printf("路径为："+filepath);
		File f = new File(filepath);
		if(!f.exists()) {
			f.mkdirs();
		}
		part.write(filepath + "/" + newFileName);
		Company company = new Company(company_name, company_area, company_size, company_type, company_desc, company_state, company_sort, 0, newFileName);
		CompanyDAO companyDao = new CompanyDAO();
		companyDao.save(company);
		PrintWriter out = response.getWriter();
		out.print("<script>");
		out.print("alert('企业信息添加成功');");
		out.print("window.location='manage/companyList.html';");
		out.print("</script>");
	}

}
