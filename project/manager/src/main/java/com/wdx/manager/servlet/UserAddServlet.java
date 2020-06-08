package com.wdx.manager.servlet;

import com.wdx.manager.bean.User;
import com.wdx.manager.dao.UserDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class UserAddServlet
 */
@WebServlet("/UserAddServlet")
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAddServlet() {
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
		String user_logname = request.getParameter("userLogname");
		String user_pwd = request.getParameter("userPwd");
		String user_realname = request.getParameter("userRealname");
		String user_email = request.getParameter("userEmail");
		Integer user_role = Integer.parseInt(request.getParameter("userRole"));
		Integer user_state = Integer.parseInt(request.getParameter("userState"));
		User user = new User(user_logname, user_pwd, user_realname, user_email, user_role, user_state);
		UserDAO userDao = new UserDAO();
		userDao.save(user);
		// 添加成功，重定向到响应页面
		response.sendRedirect("manage/userList.html");
	}
}

