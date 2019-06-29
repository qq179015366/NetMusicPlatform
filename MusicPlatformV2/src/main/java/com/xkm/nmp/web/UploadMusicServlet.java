package com.xkm.nmp.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class UploadMusicServlet extends HttpServlet{
	private ResourceBundle rb=ResourceBundle.getBundle("upload");
	
	private String uploadFolder=null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		uploadFolder=rb.getString("upload.folder");
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Part p = request.getPart("music");
		InputStream in=p.getInputStream();
		String name=p.getSubmittedFileName();
		System.out.println(name);

		File folder=new File(uploadFolder,name);
		if(!folder.exists()){
			folder.createNewFile();
		}
		OutputStream out=new FileOutputStream(folder);
		byte[] b=new byte[1024];
		
		int len=0;
		while((len=in.read(b, 0, b.length))!=-1) {

			out.write(b, 0, len);
		}
		
		if(out!=null) {
			out.close();
		}
		if(in!=null) {
			in.close();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

}
