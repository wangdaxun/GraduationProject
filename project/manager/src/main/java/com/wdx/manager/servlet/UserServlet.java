package com.wdx.manager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wdx.manager.bean.User;
import com.wdx.manager.bean.UserPageBean;
import com.wdx.manager.dao.UserDAO;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
		String type = request.getParameter("type") == null ? "login" : request.getParameter("type");
		if("login".equals(type)) {
			// 如果没登陆默认type为login状态
			String username = request.getParameter("userLogname");
			String password = request.getParameter("userPwd");
			// 获取用户提交的验证码
			String validateCode = request.getParameter("validateCode");
			// 获取本次请求会话中保存的验证码
			String sessionValidateCode = (String)request.getSession().getAttribute("SESSION_VALIDATECODE");
			User user = new User();
			UserDAO userDAO = new UserDAO();
			user = userDAO.getOne(username, password);
			if(user.getUser_logname() == null){
				out.print("<script>");
				out.print("alert('用户名或密码输入错误');");
				out.print("window.location='./login.html';");
				out.print("</script>");
			}else if (!validateCode.equals(sessionValidateCode)) {
				out.print("<script>");
				out.print("alert('验证码输入错误');");
				out.print("window.location='./login.html';");
				out.print("</script>");
			}else {
				request.getSession().setAttribute("SESSION_USER", user);
				System.out.println(111);
				response.sendRedirect("./manage/main.html");
			}
		}else if("list".equals(type)) {
			// 初始化定义数据
			Integer pageNo = request.getParameter("pageNo").charAt(0) == 'h' ? 1 : Integer.parseInt(request.getParameter("pageNo"));
			Integer pageSize = null;
			Integer totalPages = null;
			ArrayList<User> pageData = new ArrayList<User>();
			Boolean hasNext = null;
			Boolean hasPreviousPage = null;
			UserPageBean userPageBean = new UserPageBean();
			// 赋值
			pageSize = userPageBean.getPageSize();
			totalPages = userPageBean.getTotalPages();
			// 要首先把pageNo,totalPages值给赋到Bean里，才能获取到总页数
			userPageBean.setPageNo(pageNo);
			userPageBean.setTotalPages(totalPages);
			pageData = userPageBean.getPageData();
			hasNext = userPageBean.isHasNextPage();
			hasPreviousPage = userPageBean.isHasPreviousPage();
			// 将设置好的值传到bean里
			userPageBean.setPageSize(pageSize);
			userPageBean.setPageData(pageData);
			userPageBean.setHasPreviousPage(hasPreviousPage);
			userPageBean.setHasNext(hasNext);
			// 将这个对象通过json传到前台
			Gson gson = new Gson();
			String pageList = gson.toJson(userPageBean);
			out.print(pageList);
		}else if("updateSelect".equals(type)) {
			// 根据id找一个用户
			Integer id = Integer.parseInt(request.getParameter("userId"));
			User user = new User();
			UserDAO userDao = new UserDAO();
			user = userDao.getOne(id);
			Gson gson = new Gson();
			String oneUser = gson.toJson(user);
			out.print(oneUser);
		}else if("update".equals(type)) {
			// 根据传过来的id修改用户的信息
			Integer id = Integer.parseInt(request.getParameter("userId"));
			// 解析request
			String userLogname = request.getParameter("userLogname");
			String userPwd = request.getParameter("userPwd");
			String userRealname = request.getParameter("userRealname");
			String userEmail = request.getParameter("userEmail");
			Integer userRole = Integer.parseInt(request.getParameter("userRole"));
			Integer userState = Integer.parseInt(request.getParameter("userState"));
			User user = new User(userLogname, userPwd, userRealname, userEmail, userRole, userState);
			user.setUser_id(id);
			UserDAO userDao = new UserDAO();
			userDao.update(user);
			out.print("<script>");
			out.print("alert('用户信息修改成功');");
			out.print("window.location='manage/userList.html';");
			out.print("</script>");
		}else if(("userSelect").equals(type)) {
			// 查询listener里存储的application
			ServletContext servletContext = this.getServletContext();
			Map<String,User> onlineUserMap = (Map<String,User>) servletContext.getAttribute("ONLINE_USER");
			
			Gson gson = new Gson();
			String online = gson.toJson(onlineUserMap);
			System.out.println(online);
			out.print(online);
		}
		else if("logout".equals(type)) {
			// 返回登陆页面
			out.print("<script>");
			out.print("alert('退出成功');");
			out.print("window.location='./login.html';");
			out.print("</script>");
			// 用户本次会话失效
			request.getSession().invalidate();
		}
	}
}
