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
 * Servlet implementation class RegisterServlett
 */
public class RegisterServlett extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService us=new UserService();
    private User user=new User();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlett() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String type = request.getParameter("type");
		PrintWriter pw=response.getWriter();
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		String sex=request.getParameter("sex");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		user.setUname(uname);
		user.setPassword(password);
		user.setSex(Integer.parseInt(sex));
		user.setPhone(phone);
		user.setEmail(email);
		user.setStatus(1);
		//为避免和之后的查询冲突，让新线程执行插入，主线程暂停一会等插入完成再查
		new Thread() {
			public void run() {
				us.addUser(user);
			}
		}.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		user=us.checkUser(uname, password);
		String json=GsonUtil.getJsonString(user);
		pw.print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
