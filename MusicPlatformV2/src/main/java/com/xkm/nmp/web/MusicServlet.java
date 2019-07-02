package com.xkm.nmp.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xkm.nmp.core.utils.GsonUtil;
import com.xkm.nmp.pojo.LayuiJson;
import com.xkm.nmp.pojo.Music;
import com.xkm.nmp.service.MusicService;

/**
 * Servlet implementation class MusicServlet
 */
public class MusicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MusicService ms = new MusicService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MusicServlet() {
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

		if ("music_pool_list".equals(type)) {
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
			Integer total = ms.queryAllCount();
			List<Music> musics = ms.queryAll(page, pageSize);
			LayuiJson layJson = new LayuiJson();
			layJson.setCode(0);
			if (total != null)
				layJson.setCount(total);
			else
				layJson.setCount(0);
			layJson.setData(musics);
			String jsondata = GsonUtil.getJsonString(layJson);
			pw.print(jsondata);
		} else if ("del_music".equals(type)) {
			String mids = request.getParameter("mid");
			Long mid = Long.parseLong(mids);
			ms.delMusic(mid);
			pw.print("ok");
		} else if ("e_music_list".equals(type)) {
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
			Integer total = ms.queryAllUnderReviewCount();
			List<Music> musics = ms.queryAllUnderReview(page, pageSize);
			LayuiJson layJson = new LayuiJson();
			layJson.setCode(0);
			if (total != null)
				layJson.setCount(total);
			else
				layJson.setCount(0);
			layJson.setData(musics);
			String jsondata = GsonUtil.getJsonString(layJson);
			pw.print(jsondata);
		} else if ("pass_music".equals(type)) {
			String mids = request.getParameter("mid");
			Long mid = Long.parseLong(mids);
			ms.renewMusic(mid);
			pw.print("ok");
		} else if ("del_music_list".equals(type)) {
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
			Integer total = ms.queryAllDelMusicCount();
			List<Music> musics = ms.queryAllDelMusic(page, pageSize);
			LayuiJson layJson = new LayuiJson();
			layJson.setCode(0);
			if (total != null)
				layJson.setCount(total);
			else
				layJson.setCount(0);
			layJson.setData(musics);
			String jsondata = GsonUtil.getJsonString(layJson);
			pw.print(jsondata);
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
