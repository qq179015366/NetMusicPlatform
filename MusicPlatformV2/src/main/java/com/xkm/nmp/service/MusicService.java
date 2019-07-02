package com.xkm.nmp.service;

import java.util.List;

import com.xkm.nmp.dao.MusicDAOImpl;
import com.xkm.nmp.pojo.Music;

public class MusicService {
	private MusicDAOImpl dao = new MusicDAOImpl();

	// ��Ӹ���
	public void addMusic(Music music) {
		dao.addMusic(music);
	}

	// ��������ѯ����
	public List<Music> queryByCondition(String searchCondition, int page, int pageSize) {
		int start = (page - 1) * pageSize;
		int end = pageSize;
		return dao.queryByCondition(searchCondition, start, end);
	}

	// ��ѯ����
	public List<Music> queryAll(int page, int pageSize) {
		int start = (page - 1) * pageSize;
		int end = pageSize;
		return dao.queryAll(start, end);
	}

	public List<Music> queryAllDelMusic(int page, int pageSize) {
		int start = (page - 1) * pageSize;
		int size = pageSize;
		return dao.queryAllDelMusic(start, size);
	}

	public List<Music> queryAllUnderReview(int page, int pageSize) {
		int start = (page - 1) * pageSize;
		int size = pageSize;
		return dao.queryAllUnderReview(start, size);
	}

	// �ָ�����
	public void renewMusic(Long mid) {
		dao.renewMusic(mid);
	}

	// ɾ������
	public void delMusic(Long mid) {
		dao.delMusic(mid);
	}

	// ��������ѯ�ܽ����
	public Integer queryByConditionCount(String searchCondition) {
		return dao.queryByConditionCount(searchCondition);
	}

	// ���ݸ赥id��ѯ����
	public List<Music> queryByMlid(Long mlid, int page, int pageSize) {
		int start = (page - 1) * pageSize;
		int end = pageSize;
		return dao.queryByMlid(mlid, start, end);
	}

	// �������ܽ����
	public Integer queryAllCount() {
		return dao.queryAllCount();
	}

	// δ�ڸ������ܽ����
	public Integer queryAllUnderReviewCount() {
		return dao.queryAllUnderReviewCount();
	}

	// ��ɾ���ĸ����������
	public Integer queryAllDelMusicCount() {
		return dao.queryAllDelMusicCount();
	}

}
