package com.xkm.nmp.dao;

import com.xkm.nmp.pojo.Music;

public interface IMusicDAO {
	//����
	public void addMusic(Music music);
	
	//�ָ�
	public void renewMusic(Long mid);
	
	//ɾ��
	public void delMusic(Long mid);

}
