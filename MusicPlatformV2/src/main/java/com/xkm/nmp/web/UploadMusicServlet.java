package com.xkm.nmp.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.xkm.nmp.pojo.Music;
import com.xkm.nmp.pojo.User;
import com.xkm.nmp.service.MusicService;

@MultipartConfig
public class UploadMusicServlet extends HttpServlet {
	private ResourceBundle rb = ResourceBundle.getBundle("upload");

	private String uploadFolder = null;

	private MusicService ms = new MusicService();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		uploadFolder = rb.getString("upload.folder");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();

		Part p = request.getPart("music");
		InputStream in = p.getInputStream();
		// String name=p.getSubmittedFileName();
		String mname = request.getParameter("mname");
		// 拿到session中的当前用户
		User user = (User) request.getSession().getAttribute("user");
		mname = mname + "_" + user.getUid() + ".mp3";
		File folder = new File(uploadFolder, mname);
		if (!folder.exists()) {
			folder.createNewFile();
		}
		OutputStream out = new FileOutputStream(folder);
		byte[] b = new byte[1024];
		int len = 0;
		while ((len = in.read(b, 0, b.length)) != -1) {
			out.write(b, 0, len);
		}
		if (out != null) {
			out.close();
		}
		if (in != null) {
			in.close();
		}

		Music music = new Music();
		music.setMname(request.getParameter("mname"));
		music.setAuthor(request.getParameter("author"));
		music.setStyle(Integer.parseInt(request.getParameter("style")));
		music.setUploader(user.getUid());
		music.setPlaytimes(0);
		music.setUploaddate(new Date());
		music.setLyric(null);
		music.setStatus(0);
		// 加入数据库
		try {
			ms.addMusic(music);
		} catch (Exception e) {
			e.printStackTrace();
			pw.print("fail");
		}
		pw.print("ok");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
