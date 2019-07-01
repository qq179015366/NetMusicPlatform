package com.xkm.nmp.pojo;

import java.io.Serializable;
import java.util.List;


/**
 * ���صı�����ݶ���
 * @author ������
 *
 * @param <T>
 */
public class TableData<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Pager pager;
	
	private List<T> data;

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	} 
	
}
