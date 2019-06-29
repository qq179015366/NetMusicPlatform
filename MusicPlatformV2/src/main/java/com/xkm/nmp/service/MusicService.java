package com.xkm.nmp.service;

import com.xkm.nmp.dao.MusicDAOImpl;
import com.xkm.nmp.pojo.Music;

public class MusicService {
	private MusicDAOImpl dao=new MusicDAOImpl();
	
	//Ìí¼Ó¸èÇú
	public void addMusic(Music music) {
		dao.addMusic(music);
	}
	
	//»Ö¸´¸èÇú
	public void renewMusic(Long mid) {
		dao.renewMusic(mid);
	}
	
	//É¾³ý¸èÇú
	public void delMusic(Long mid) {
		dao.delMusic(mid);
	}

}
