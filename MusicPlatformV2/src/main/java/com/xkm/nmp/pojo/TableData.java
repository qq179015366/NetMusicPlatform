package com.xkm.nmp.pojo;

import java.io.Serializable;
import java.util.List;


/**
 * 返回的表格数据对象
 * @author 胥珂铭
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
