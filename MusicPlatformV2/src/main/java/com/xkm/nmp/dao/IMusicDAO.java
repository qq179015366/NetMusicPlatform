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

	// 查询未审查歌曲
	public List<Music> queryAllUnderReview(int start, int size);

	// 查询所有被删除的歌曲
	public List<Music> queryAllDelMusic(int start, int size);

	// 歌曲池总结果数
	public Integer queryAllCount();

	// 未在歌曲池总结果数
	public Integer queryAllUnderReviewCount();

	// 被删除歌曲总结果数
	public Integer queryAllDelMusicCount();

	// 查询对应歌单的音乐
	public List<Music> queryByMlid(Long mlid, int start, int end);

	// 恢复
	public void renewMusic(Long mid);

	// 删除
	public void delMusic(Long mid);

}
