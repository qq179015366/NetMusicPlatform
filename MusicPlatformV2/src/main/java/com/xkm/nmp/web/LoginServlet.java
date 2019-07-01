package com.xkm.nmp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xkm.nmp.core.utils.GsonUtil;
import com.xkm.nmp.pojo.User;
import com.xkm.nmp.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		PrintWriter pw = response.getWriter();

		if ("login".equals(type)) {
			// 登录
			String uname = request.getParameter("uname");
			String password = request.getParameter("password");
			User user = us.checkUser(uname, password);
			if (user != null && user.getStatus() != 0) {
				request.getSession().setAttribute("user", user);
				String json = GsonUtil.getJsonString(user);
				pw.print(json);
			} else if (user != null && user.getStatus() == 0) {
				User u0 = new User();
				u0.setUid((long) 0);
				String json = GsonUtil.getJsonString(u0);
				pw.print(json);
			} else {
				User u1 = new User();
				u1.setUid((long) 1);
				String jsondata = GsonUtil.getJsonString(u1);
				pw.print(jsondata);
			}
		} else if ("unameTest".equals(type)) {
			// 验证用户名
			String uname = request.getParameter("uname");
			User user = us.getUserByUname(uname);
			if (user != null)
				pw.print("exist");
			else
				pw.print("ok");
		} else if ("loadData".equals(type)) {
			//载入数据
			User user=null;
			try {
				user=(User)request.getSession().getAttribute("user");
				if(user==null) {
					user=new User();
					user.setUid((long)-1);
				}
			} catch (Exception e) {
				user=new User();
				user.setUid((long)-1);
			}
			String jsondata=GsonUtil.getJsonString(user);
			pw.print(jsondata);
		}else if("exit".equals(type)) {
			request.getSession().invalidate();
			pw.print("ok");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
