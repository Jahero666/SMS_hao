package com.bao.domain;
/**
 * ѧ��ʵ����
 * @author Administrator
 *
 */
public class Student {
	//�����ݿ��Ӧ��4������
	private int id;//����ѧ����Ψһ��,����
	private String name;
	private String myclass;
	private double score;
	
	
	/**
	 * ����ѧ������,�༶,�ͳɼ������µ�ѧ����
	 * @param name
	 * @param myclass
	 * @param socre
	 */
	public Student(String name, String myclass, double score) {
		this.name = name;
		this.myclass = myclass;
		this.score = score;
	}
	public Student(int id, String name, String myclass, double score) {
		super();
		this.id = id;
		this.name = name;
		this.myclass = myclass;
		this.score = score;
	}

	/**
	 * �޲ι���
	 */
	public Student() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMyclass() {
		return myclass;
	}
	public void setMyclass(String myclass) {
		this.myclass = myclass;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "id = " + this.id + 
				" name = " + this.name + 
				" myclass = " + this.myclass + 
				" score = " + this.score;
	}
}
