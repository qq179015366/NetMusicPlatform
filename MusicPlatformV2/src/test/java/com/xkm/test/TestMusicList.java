package com.xkm.test;

import java.util.List;

import com.xkm.nmp.pojo.MusicList;
import com.xkm.nmp.service.MusicListService;

public class TestMusicList {

	public static void main(String[] args) {
		MusicListService mls=new MusicListService();
		List<MusicList> ml=mls.queryAll((long)108);
		
		ml.forEach(e->System.out.println(e.getMlname()));
	}
	
}
