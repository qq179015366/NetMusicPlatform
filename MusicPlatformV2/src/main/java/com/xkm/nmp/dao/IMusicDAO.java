package com.xkm.nmp.dao;

import java.util.List;

import com.xkm.nmp.pojo.Music;

public interface IMusicDAO {
	// ����
	public void addMusic(Music music);

	// ��������������
	public List<Music> queryByCondition(String searchCondition, int start, int end);

	// ��������ѯ�ܽ����
	public Integer queryByConditionCount(String searchCondition);

	// ���������и���
	public List<Music> queryAll(int start, int end);

	// �������ܽ����
	public Integer queryAllCount();

	// �ָ�
	public void renewMusic(Long mid);

	// ɾ��
	public void delMusic(Long mid);

}
