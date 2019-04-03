package com.bao.dao;

import java.util.List;

import com.bao.domain.Student;

/**
 * �������ݵ���ɾ�Ĳ�ķ��� ������������,����ѧ�Ų���,������������,����һ��ѧ��,�޸�һ��ѧ��,ɾ��һ��ѧ��
 * 
 * @author Administrator
 *
 */
public interface IStudentDao {
	public List<Student> findAll();

	public Student findById(int sid);

	public List<Student> findByName(String name);
	
	public List<Student> findByClass(String myclass);
	
	public List<Student> findByScore(int score) ;

	public int add(Student student);

	public int modify(Student student);

	public int delete(int sid);

	// ��ҳ��Ҫ��dao����
	// 1.������м�¼��������
	public int findTotalCount();

	// 2.��ѯ��ǰҳ�ļ�¼����
	public List<Student> findOnePage(int pageIndex, int pageSize);
}
