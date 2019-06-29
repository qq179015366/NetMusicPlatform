package com.xkm.nmp.service;

import com.xkm.nmp.dao.MusicDAOImpl;
import com.xkm.nmp.pojo.Music;

public class MusicService {
	private MusicDAOImpl dao=new MusicDAOImpl();
	
	//��Ӹ���
	public void addMusic(Music music) {
		dao.addMusic(music);
	}
	
	//�ָ�����
	public void renewMusic(Long mid) {
		dao.renewMusic(mid);
	}
	
	//ɾ������
	public void delMusic(Long mid) {
		dao.delMusic(mid);
	}

}
