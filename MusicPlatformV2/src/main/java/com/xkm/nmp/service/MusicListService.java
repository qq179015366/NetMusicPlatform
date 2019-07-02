package com.xkm.nmp.service;

import java.util.List;

import com.xkm.nmp.dao.MusicListDAOImpl;
import com.xkm.nmp.pojo.MusicList;

public class MusicListService {

	private MusicListDAOImpl dao = new MusicListDAOImpl();

	public void addMusicList(MusicList musicList) {
		dao.addMusicList(musicList);
	}

	public List<MusicList> queryAll(Long uid) {
		return dao.queryAll(uid);
	}

	public void addMusicToMusicList(Long mlid, Long mid) throws Exception {
		dao.addMusicToMusicList(mlid, mid);
	}

}
