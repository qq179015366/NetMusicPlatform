package com.xkm.nmp.pojo;

import java.io.Serializable;

public class EvaluationForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long evid;
	private Long mid;
	private Integer status;
	private String result;

	public Long getEvid() {
		return evid;
	}

	public void setEvid(Long evid) {
		this.evid = evid;
	}

	public Long getMid() {
		return mid;
	}

	public void setMid(Long mid) {
		this.mid = mid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
