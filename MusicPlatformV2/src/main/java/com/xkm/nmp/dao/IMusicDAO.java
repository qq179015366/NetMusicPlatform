package com.xkm.nmp.dao;

import com.xkm.nmp.pojo.Music;

public interface IMusicDAO {
	//²åÈë
	public void addMusic(Music music);
	
	//»Ö¸´
	public void renewMusic(Long mid);
	
	//É¾³ý
	public void delMusic(Long mid);

}
