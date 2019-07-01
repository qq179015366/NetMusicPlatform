package com.xkm.nmp.dao;

import java.util.List;

import com.xkm.nmp.pojo.Music;

public interface IMusicDAO {
	// 插入
	public void addMusic(Music music);

	// 按条件检索歌曲
	public List<Music> queryByCondition(String searchCondition, int start, int end);

	// 按条件查询总结果数
	public Integer queryByConditionCount(String searchCondition);

	// 歌曲池所有歌曲
	public List<Music> queryAll(int start, int end);

	// 歌曲池总结果数
	public Integer queryAllCount();

	// 恢复
	public void renewMusic(Long mid);

	// 删除
	public void delMusic(Long mid);

}
