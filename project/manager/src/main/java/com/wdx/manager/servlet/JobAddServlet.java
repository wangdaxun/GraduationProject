package com.wdx.manager.servlet;

import com.wdx.manager.bean.Job;
import com.wdx.manager.dao.JobDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
@MultipartConfig
@WebServlet("/JobAddServlet")
public class JobAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JobDAO jobDao = new JobDAO();
        response.setHeader("content-Type","text/html;charset=utf-8");
        String job_name = request.getParameter("jobName");
        String company_name = request.getParameter("comanyName");
        String job_hiringnum = request.getParameter("jobHiringnum");
        String job_lianxiren = request.getParameter("jobLianxiren");
        String job_salary = request.getParameter("jobSalary");
        String job_area = request.getParameter("jobArea");
        String job_zhiwei = request.getParameter("jobZhiwei");
        String job_zhize = request.getParameter("jobZhize");
        // 获取上传文件域
        Part part = request.getPart("jobPic");
        // 获取上传文件名称
        String fileName = part.getSubmittedFileName();
        Job job = new Job();
        job.setJobName(job_name);
        job.setCompanyName(company_name);
        job.setJobHiringnum(Integer.parseInt(job_hiringnum));
        job.setJobPic(fileName);
        job.setJobSalary(job_salary);
        job.setJobArea(job_area);
        job.setJobZhiwei(job_zhiwei);
        job.setJobZhize(job_zhize);
        job.setJobLianxiren(job_lianxiren);
        jobDao.save(job);
        PrintWriter out = response.getWriter();
        out.print("<script>");
        out.print("alert('新的职位添加成功');");
        out.print("window.location='manage/jobList.html';");
        out.print("</script>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
