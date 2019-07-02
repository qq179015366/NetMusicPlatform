package com.xkm.test;

import java.util.List;

import com.xkm.nmp.pojo.Music;
import com.xkm.nmp.service.MusicService;

public class TestAddMusic {
	public static void main(String[] args) {
		MusicService ms = new MusicService();
		List<Music> musics = ms.queryByMlid((long) 1, 1, 15);
		musics.forEach(m -> System.out.println(m.getMname()));
		// Music music = new Music();
		// music.setMname("≤‚ ‘“Ù¿÷2.mp3");
		// music.setAuthor("Ò„ÁÊ√˙2");
		// music.setStyle(2);
		// music.setUploader((long) 101);
		// music.setUploaddate(new Date());
		// music.setPlaytimes(0);;
		// music.setLyric(null);
		// music.setStatus(0);
		// ms.addMusic(music);
		ms.renewMusic((long) 2);
	}

}
