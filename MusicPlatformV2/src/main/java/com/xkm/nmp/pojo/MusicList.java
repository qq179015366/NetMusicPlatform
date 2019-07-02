package com.xkm.nmp.pojo;

import java.io.Serializable;

public class MusicList implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long mlid;
	private Long uid;
	private String mlname;
	private String detail;

	public Long getMlid() {
		return mlid;
	}

	public void setMlid(Long mlid) {
		this.mlid = mlid;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getMlname() {
		return mlname;
	}

	public void setMlname(String mlname) {
		this.mlname = mlname;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
