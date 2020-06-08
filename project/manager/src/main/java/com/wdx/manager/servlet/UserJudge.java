package com.wdx.manager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wdx.manager.bean.User;


/**
 * Servlet implementation class UserJudge
 */
@WebServlet("/UserJudge")
public class UserJudge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserJudge() {
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
		String type = request.getParameter("type");
		if("userNameJudge".equals(type)) {
			User user = (User)request.getSession().getAttribute("SESSION_USER");
			System.out.println(user);
			Gson gson = new Gson();
			String TheUser = gson.toJson(user);
			out.print(TheUser);
		}
	}

}
