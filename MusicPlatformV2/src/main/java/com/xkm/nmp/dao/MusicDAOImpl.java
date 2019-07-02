package com.xkm.nmp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.xkm.nmp.core.utils.SqlSessionFactoryUtil;
import com.xkm.nmp.pojo.Music;

public class MusicDAOImpl implements IMusicDAO {
	SqlSessionFactory sf = SqlSessionFactoryUtil.getSqlSessionFactory();
	SqlSession s = null;

	// 插入
	@Override
	public void addMusic(Music music) {
		s = sf.openSession(true);
		IMusicDAO mapper = s.getMapper(IMusicDAO.class);
		mapper.addMusic(music);
		s.close();

	}

	// 恢复
	@Override
	public void renewMusic(Long mid) {
		s = sf.openSession(true);
		IMusicDAO mapper = s.getMapper(IMusicDAO.class);
		mapper.renewMusic(mid);
		s.close();

	}

	// 删除
	@Override
	public void delMusic(Long mid) {
		s = sf.openSession(true);
		IMusicDAO mapper = s.getMapper(IMusicDAO.class);
		mapper.delMusic(mid);
		s.close();
	}

	// 根据条件查询歌曲
	@Override
	public List<Music> queryByCondition(String searchCondition, int start, int end) {
		s = sf.openSession();
		IMusicDAO mapper = s.getMapper(IMusicDAO.class);
		List<Music> musics = mapper.queryByCondition(searchCondition, start, end);
		s.close();
		return musics;
	}

	// 查询所有歌曲
	@Override
	public List<Music> queryAll(int start, int end) {
		s = sf.openSession();
		IMusicDAO mapper = s.getMapper(IMusicDAO.class);
		List<Music> musics = mapper.queryAll(start, end);
		s.close();
		return musics;
	}

	// 按条件查询总结果数
	@Override
	public Integer queryByConditionCount(String searchCondition) {
		s = sf.openSession();
		IMusicDAO mapper = s.getMapper(IMusicDAO.class);
		Integer total = mapper.queryByConditionCount(searchCondition);
		s.close();
		return total;
	}

	// 歌曲池总结果数
	@Override
	public Integer queryAllCount() {
		s = sf.openSession();
		IMusicDAO mapper = s.getMapper(IMusicDAO.class);
		Integer total = mapper.queryAllCount();
		s.close();
		return total;
	}

	@Override
	public List<Music> queryByMlid(Long mlid, int start, int end) {
		s = sf.openSession();
		IMusicDAO mapper = s.getMapper(IMusicDAO.class);
		List<Music> musics = mapper.queryByMlid(mlid, start, end);
		s.close();
		return musics;
	}

	@Override
	public List<Music> queryAllUnderReview(int start, int size) {
		s = sf.openSession();
		IMusicDAO mapper = s.getMapper(IMusicDAO.class);
		List<Music> musics = mapper.queryAllUnderReview(start, size);
		s.close();
		return musics;
	}

	@Override
	public List<Music> queryAllDelMusic(int start, int size) {
		s = sf.openSession();
		IMusicDAO mapper = s.getMapper(IMusicDAO.class);
		List<Music> musics = mapper.queryAllDelMusic(start, size);
		s.close();
		return musics;
	}

	@Override
	public Integer queryAllUnderReviewCount() {
		s = sf.openSession();
		IMusicDAO mapper = s.getMapper(IMusicDAO.class);
		Integer total = mapper.queryAllUnderReviewCount();
		s.close();
		return total;
	}

	@Override
	public Integer queryAllDelMusicCount() {
		s = sf.openSession();
		IMusicDAO mapper = s.getMapper(IMusicDAO.class);
		Integer total = mapper.queryAllDelMusicCount();
		return total;
	}

}
