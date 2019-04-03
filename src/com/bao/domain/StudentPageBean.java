package com.bao.domain;

import java.util.List;

/**
 * ѧ����ҳʵ����
 * @param <T>
 */
public class StudentPageBean<T> {
	private int pageIndex;// ��ǰҳ��
	private int pageSize;// ÿҳ����������
	private int count;// ����������
	private int pageCount;// һ����ҳ��
	private int start;// ��ʼ����λ��
	private int end;// ����
	private List<T> list = null; // �洢��ǰҳ��¼�ļ���

	/**
	 * һЩ����ĳ�ʼ������
	 */
	public void init(){
		//1.������ҳ��pageCount
		if(count % pageSize == 0)//ǡ����ÿҳ������������
			pageCount = count / pageSize;
		else					//������+1
			pageCount = count / pageSize + 1;
		
		//2.�жϵ�ǰҳ��pageIndex�Ƿ�Ϸ�
		if(pageIndex < 1)
			pageIndex = 1;
		if(pageIndex > pageCount)
			pageIndex = pageCount;
		
		//3.���㵱ǰҳ�ĵ�һ�� �� ���һ����λ��
		start = (pageIndex - 1) * pageSize;
		
		if((pageIndex * pageSize) > count)//����������������ÿҳ������������,��֤�����һҳ����,���һ�м�Ϊ������
			end = count;
		else
			end = start + pageSize;//��������������
	}
	
	public StudentPageBean() {
		super();
	}

	public StudentPageBean(int pageIndex, int pageSize, int count) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.count = count;
	}

	public StudentPageBean(int pageIndex, int pageSize, int count, List<T> list) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.count = count;
		this.list = list;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
