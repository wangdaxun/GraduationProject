package com.wdx.servlet;

import com.wdx.dao.ResumeDAO;
import com.wdx.domain.Applicant;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



@WebServlet("/ResumePicUploadServlet")
@MultipartConfig
public class ResumePicUploadServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResumePicUploadServlet() {
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
		// 获取上传上传域
		Part part = request.getPart("headShot");
		// 获取上传文件名称
		String fileName = part.getSubmittedFileName();
		// 为防止上传文件重名，对文件进行重命名
		String newFileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
		// 将上传的文件保存在服务器根目录下的upload/companyPic子目录下
		String filepath = getServletContext().getRealPath("/");
		// filepath = filepath.substring(0, filepath.indexOf(getServletContext().getServletContextName()));
		filepath = filepath + "upload/resumePic";
		System.out.printf("路径为："+filepath);
		File f = new File(filepath);
		if(!f.exists()) {
			f.mkdirs();
		}
		part.write(filepath + "/" + newFileName);
		// 更新简历照片
		Applicant applicant = (Applicant)request.getSession().getAttribute("SESSION_APPLICANT");
		ResumeDAO resumeDao = new ResumeDAO();
		resumeDao.updateHeadShot(applicant.getApplicantId(), newFileName);
		// 照片更新成功，回到“我的简历”页面
		response.sendRedirect("applicant/resume.html");
	}
}
