package com.xkm.nmp.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xkm.nmp.core.utils.GsonUtil;
import com.xkm.nmp.pojo.Music;
import com.xkm.nmp.pojo.Pager;
import com.xkm.nmp.pojo.TableData;
import com.xkm.nmp.service.MusicService;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MusicService ms = new MusicService();
	private String searchCondition = null;
	private Pager musicPager = new Pager();
	private Pager musicListPager = new Pager();
	private Pager authorPager = new Pager();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
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
		PrintWriter pw = response.getWriter();
		String type = request.getParameter("type");

		// 搜索音乐
		if ("searchMusic".equals(type)) {
			// 设置页面规模
			musicPager.setPageSize(5);
			// 设置当前页
			if (request.getParameter("currentPage") == null || request.getParameter("currentPage").equals(""))
				musicPager.setCurrentPage(1);
			else
				musicPager.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));

			// 搜索条件
			searchCondition = request.getParameter("searchCondition");

			if (searchCondition.equals("")) {
				setPager(ms.queryAllCount());
				List<Music> musics = ms.queryAll(musicPager.getCurrentPage(), musicPager.getPageSize());
				// 返回的表格数据对象
				TableData<Music> tdata = new TableData<Music>();
				tdata.setData(musics);
				tdata.setPager(musicPager);
				String jsondata = GsonUtil.getJsonString(tdata);
				pw.print(jsondata);
			} else {
				setPager(ms.queryByConditionCount(searchCondition));
				searchCondition = "%" + searchCondition + "%";
				List<Music> musics = ms.queryByCondition(searchCondition, musicPager.getCurrentPage(),
						musicPager.getPageSize());
				// 返回的表格数据对象
				TableData<Music> tdata = new TableData<Music>();
				tdata.setData(musics);
				tdata.setPager(musicPager);
				String jsondata = GsonUtil.getJsonString(tdata);
				pw.print(jsondata);
			}
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

	private void setPager(Integer total) {
		if (total != null) {
			musicPager.setTotalData(total);
			// 总数据不能整除每页数据数则总页数+1
			if (total % musicPager.getPageSize() != 0)
				musicPager.setPageNum(total / musicPager.getPageSize() + 1);
			else
				musicPager.setPageNum(total / musicPager.getPageSize());
		} else {
			musicPager.setTotalData(0);
			musicPager.setPageNum(0);
		}
	}

}
