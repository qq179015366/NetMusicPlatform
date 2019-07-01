package com.xkm.nmp.service;

import java.util.List;

import com.xkm.nmp.dao.MusicDAOImpl;
import com.xkm.nmp.pojo.Music;

public class MusicService {
	private MusicDAOImpl dao = new MusicDAOImpl();

	// 添加歌曲
	public void addMusic(Music music) {
		dao.addMusic(music);
	}

	// 按条件查询歌曲
	public List<Music> queryByCondition(String searchCondition, int page, int pageSize) {
		int start = (page - 1) * pageSize;
		int end = pageSize;
		return dao.queryByCondition(searchCondition, start, end);
	}

	// 查询所有
	public List<Music> queryAll(int page, int pageSize) {
		int start = (page - 1) * pageSize;
		int end = pageSize;
		return dao.queryAll(start, end);
	}

	// 恢复歌曲
	public void renewMusic(Long mid) {
		dao.renewMusic(mid);
	}

	// 删除歌曲
	public void delMusic(Long mid) {
		dao.delMusic(mid);
	}

	// 按条件查询总结果数
	public Integer queryByConditionCount(String searchCondition) {
		return dao.queryByConditionCount(searchCondition);
	}

	// 歌曲池总结果数
	public Integer queryAllCount() {
		return dao.queryAllCount();
	}

}
