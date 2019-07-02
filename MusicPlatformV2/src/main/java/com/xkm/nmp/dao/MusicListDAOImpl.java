package com.xkm.nmp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.xkm.nmp.core.utils.SqlSessionFactoryUtil;
import com.xkm.nmp.pojo.MusicList;

public class MusicListDAOImpl implements IMusicListDAO {

	SqlSessionFactory sf = SqlSessionFactoryUtil.getSqlSessionFactory();
	SqlSession s = null;

	// 新增歌单
	@Override
	public void addMusicList(MusicList musicList) {
		s = sf.openSession(true);
		IMusicListDAO mapper = s.getMapper(IMusicListDAO.class);
		mapper.addMusicList(musicList);
		s.close();
	}

	// 查询uid的所有歌单
	@Override
	public List<MusicList> queryAll(long uid) {
		s = sf.openSession();
		IMusicListDAO mapper = s.getMapper(IMusicListDAO.class);
		List<MusicList> musicList = mapper.queryAll(uid);
		s.close();
		return musicList;
	}

	@Override
	public void addMusicToMusicList(Long mlid, Long mid) throws Exception {
		s = sf.openSession(true);
		IMusicListDAO mapper = s.getMapper(IMusicListDAO.class);
		mapper.addMusicToMusicList(mlid, mid);
		s.close();
	}

}
