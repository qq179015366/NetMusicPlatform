package com.xkm.nmp.dao;

import java.util.List;

import com.xkm.nmp.pojo.MusicList;

public interface IMusicListDAO {

	// ��Ӹ赥
	public void addMusicList(MusicList musicList);

	// ����uid��ѯ���и赥
	public List<MusicList> queryAll(long uid);

	// ����������赥�Ĺ�ϵ
	public void addMusicToMusicList(Long mlid, Long mid) throws Exception;

}
