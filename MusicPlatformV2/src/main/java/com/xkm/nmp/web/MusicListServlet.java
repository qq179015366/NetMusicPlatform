package com.xkm.nmp.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xkm.nmp.core.utils.GsonUtil;
import com.xkm.nmp.pojo.MusicList;
import com.xkm.nmp.pojo.User;
import com.xkm.nmp.service.MusicListService;

/**
 * Servlet implementation class MusicListServlet
 */
public class MusicListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MusicListService mls = new MusicListService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MusicListServlet() {
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

		if ("add".equals(type)) {
			String mlname = request.getParameter("mlname");
			String detail = request.getParameter("detail");
			User user = (User) request.getSession().getAttribute("user");
			MusicList musicList = new MusicList();
			musicList.setUid(user.getUid());
			musicList.setMlname(mlname);
			musicList.setDetail(detail);
			mls.addMusicList(musicList);
			pw.print("ok");
		} else if ("getMyMusicList".equals(type)) {
			User user = (User) request.getSession().getAttribute("user");
			List<MusicList> musicLists = null;
			if (user != null)
				musicLists = mls.queryAll(user.getUid());
			String jsondata = GsonUtil.getJsonString(musicLists);
			pw.print(jsondata);
		} else if ("addMusicList_Music_Relat".equals(type)) {
			String mlids = request.getParameter("mlid");
			String mids = request.getParameter("mid");
			Long mlid = Long.parseLong(mlids);
			Long mid = Long.parseLong(mids);
			try {
				mls.addMusicToMusicList(mlid, mid);
			} catch (Exception e) {
				pw.print("fail");
			}
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
