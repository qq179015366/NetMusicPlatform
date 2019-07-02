package com.xkm.nmp.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xkm.nmp.pojo.LayuiJson;
import com.xkm.nmp.pojo.LoginManager;
import com.xkm.nmp.core.utils.GsonUtil;
import com.xkm.nmp.listener.LoginListener;
import com.xkm.nmp.pojo.User;
import com.xkm.nmp.service.UserService;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
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

		if ("user_list".equals(type)) {
			int page = 1;
			int pageSize = 10;

			String pagex = request.getParameter("page");
			String pageSizex = request.getParameter("pageSize");
			if (pagex != null) {
				try {
					page = Integer.parseInt(pagex);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
			if (pageSizex != null) {
				try {
					pageSize = Integer.parseInt(pageSizex);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
			// ·â×°
			Integer total = us.countUser();
			List<User> users = us.queryAllByPager(page, pageSize);
			LayuiJson layJson = new LayuiJson();
			layJson.setCode(0);
			if (total != null)
				layJson.setCount(total);
			else
				layJson.setCount(0);
			layJson.setData(users);
			String jsondata = GsonUtil.getJsonString(layJson);
			pw.print(jsondata);
		} else if ("block_user".equals(type)) {
			String uids = request.getParameter("uid");
			Long uid = Long.parseLong(uids);
			us.delUser(uid);
			pw.print("ok");
		} else if ("online_user_list".equals(type)) {
			Integer total = LoginManager.getSessionIds().size();
			List<User> users = LoginManager.getOnlineUsers();
			LayuiJson layJson = new LayuiJson();
			layJson.setCode(0);
			if (total != null)
				layJson.setCount(total);
			layJson.setData(users);
			String jsondata = GsonUtil.getJsonString(layJson);
			pw.print(jsondata);
		} else if ("user_block_list".equals(type)) {
			int page = 1;
			int pageSize = 10;

			String pagex = request.getParameter("page");
			String pageSizex = request.getParameter("pageSize");
			if (pagex != null) {
				try {
					page = Integer.parseInt(pagex);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
			if (pageSizex != null) {
				try {
					pageSize = Integer.parseInt(pageSizex);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
			// ·â×°
			Integer total = us.countBlockUser();
			List<User> users = us.queryBlockUser(page, pageSize);
			LayuiJson layJson = new LayuiJson();
			layJson.setCode(0);
			if (total != null)
				layJson.setCount(total);
			else
				layJson.setCount(0);
			layJson.setData(users);
			String jsondata = GsonUtil.getJsonString(layJson);
			pw.print(jsondata);
		} else if ("renew_user".equals(type)) {
			String uids = request.getParameter("uid");
			Long uid = Long.parseLong(uids);
			us.renewUser(uid);
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
