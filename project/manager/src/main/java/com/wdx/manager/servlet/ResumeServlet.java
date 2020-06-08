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
import com.wdx.manager.bean.Resume;
import com.wdx.manager.bean.ResumePageBean;
import com.wdx.manager.dao.ResumeDAO;


/**
 * Servlet implementation class ResumeServlet
 */
@WebServlet("/ResumeServlet")
public class ResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResumeServlet() {
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
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		if("list".equals(type)) {
			ResumeDAO resumeDao = new ResumeDAO();
			ResumePageBean resumePageBean = new ResumePageBean();
			ArrayList<Resume> resumeList = new ArrayList<Resume>();
			Boolean hasNext = null;
			Boolean hasPrevious = null;
			Integer pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt(request.getParameter("pageNo"));  	
			Integer total = resumeDao.getAllNum();
			resumeList = resumePageBean.getPageData();
			resumePageBean.setPageData(resumeList);
			resumePageBean.setPageNo(pageNo);
			resumePageBean.setTotalPages(total);
			hasNext = resumePageBean.isHasNext();
			hasPrevious = resumePageBean.isHasPrevious();
			resumePageBean.setHasNext(hasNext);
			resumePageBean.setHasPrevious(hasPrevious);
			request.setAttribute("ResumePageBean", resumePageBean);
			request.getRequestDispatcher("manage/resumeList.jsp").forward(request, response);;
		}else if("select".equals(type)){
			ResumeDAO resumeDao = new ResumeDAO();
			Integer id = Integer.parseInt(request.getParameter("resumeId"));
			Resume resume = new Resume();
			resume = resumeDao.getOne(id);
			Gson gson = new Gson();
			String OneResume = gson.toJson(resume);
			out.print(OneResume);
		}
		
	}

}
