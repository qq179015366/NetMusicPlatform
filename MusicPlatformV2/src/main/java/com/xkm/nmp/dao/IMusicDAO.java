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

	// ��ѯδ������
	public List<Music> queryAllUnderReview(int start, int size);

	// ��ѯ���б�ɾ���ĸ���
	public List<Music> queryAllDelMusic(int start, int size);

	// �������ܽ����
	public Integer queryAllCount();

	// δ�ڸ������ܽ����
	public Integer queryAllUnderReviewCount();

	// ��ɾ�������ܽ����
	public Integer queryAllDelMusicCount();

	// ��ѯ��Ӧ�赥������
	public List<Music> queryByMlid(Long mlid, int start, int end);

	// �ָ�
	public void renewMusic(Long mid);

	// ɾ��
	public void delMusic(Long mid);

}
