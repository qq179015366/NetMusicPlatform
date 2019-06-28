package com.xkm.nmp.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.xkm.nmp.core.utils.SqlSessionFactoryUtil;
import com.xkm.nmp.pojo.Music;

public class MusicDAOImpl implements IMusicDAO{
	SqlSessionFactory sf = SqlSessionFactoryUtil.getSqlSessionFactory();
	SqlSession s = null;

	//²åÈë
	@Override
	public void addMusic(Music music) {
		s=sf.openSession(true);
		IMusicDAO mapper = s.getMapper(IMusicDAO.class);
		mapper.addMusic(music);
		s.close();	
		
	}
	
    //»Ö¸´
	@Override
	public void renewMusic(Long mid) {
		s=sf.openSession(true);
		IMusicDAO mapper = s.getMapper(IMusicDAO.class);
		mapper.renewMusic(mid);
		s.close();
		
	}
	
	//É¾³ý
	@Override
	public void delMusic(Long mid) {
		s = sf.openSession(true);
		IMusicDAO mapper = s.getMapper(IMusicDAO.class);
		mapper.delMusic(mid);
		s.close();
	}

	
}
