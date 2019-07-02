package com.xkm.nmp.dao;

import java.util.List;

import com.xkm.nmp.pojo.MusicList;

public interface IMusicListDAO {

	// 添加歌单
	public void addMusicList(MusicList musicList);

	// 根据uid查询所有歌单
	public List<MusicList> queryAll(long uid);

	// 建立歌曲与歌单的关系
	public void addMusicToMusicList(Long mlid, Long mid) throws Exception;

}
