package com.bao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bao.dao.IStudentDao;
import com.bao.domain.Student;
import com.bao.utils.JDBCUtils;

/**
 * ʵ�ֽӿڵ���ɾ�Ĳ�ķ��� ������������,����ѧ�Ų���,������������,����һ��ѧ��,�޸�һ��ѧ��,ɾ��һ��ѧ��
 * 
 */
public class StudentDaoJdbcImpl implements IStudentDao {

	/**
	 * ��ѯ����ѧ��
	 */
	public List<Student> findAll() {
		Connection conn = null;// �������ݿ�
		PreparedStatement ps = null;// Ԥ����
		ResultSet rs = null;// �����--
		List<Student> allStu = null;// �����õĽ�����б���

		try {
			conn = JDBCUtils.getConnection();// ������ݿ�����
			String sql = "select * from t_student";// SQL���
			ps = conn.prepareStatement(sql);// ��SQL���ʵ����prepareStatement
			rs = ps.executeQuery();// ִ�в�ѯ����ý����

			while (rs.next()) {// ��������Ϊ��
				if (allStu == null) {// ֻ��Ҫ��һ��ʵ����,
					allStu = new ArrayList<Student>();// ��arrayʵ����
				}

				Student s = new Student();// newһ��studentʵ�������ڽ��ս����
				s.setId(rs.getInt("id"));// ȡ��id��д��studentʵ����
				s.setName(rs.getString("name"));// ȡ��name��д��studentʵ����
				s.setMyclass(rs.getString("myclass"));// ȡ��myclass��д��studentʵ����
				s.setScore(rs.getDouble("score"));// ȡ��socre��д��studentʵ����

				allStu.add(s);// ������ӵ�������
			}
		} catch (SQLException e) {
			System.err.println("��ѯ����ѧ��ʧ��,��鿴����ԭ��!");
			e.printStackTrace();
		}
		return allStu;
	}

	/**
	 * ���ݰ༶��ѯ,����һ��ѧ���б�
	 */
	public List<Student> findByClass(String myclass) {
		Connection conn = null;// �������ݿ�
		PreparedStatement ps = null;// Ԥ����
		ResultSet rs = null;// �����--
		List<Student> allStu = null;// �����õĽ�����б���

		try {
			conn = JDBCUtils.getConnection();// ������ݿ�����
			String sql = "select * from t_student where myclass like ";// SQL���
			sql = sql + "'%"+myclass+"%'";//֧����ģ����ѯ
			ps = conn.prepareStatement(sql);// ��SQL���ʵ����prepareStatement
			//ps.setString(1, "'%"+myclass+"%'");// �����myclass
			rs = ps.executeQuery();// ִ�в�ѯ����ý����

			while (rs.next()) {// ��������Ϊ��
				if (allStu == null) {// ֻ��Ҫ��һ��ʵ����,
					allStu = new ArrayList<Student>();// ��arrayʵ����
				}

				Student s = new Student();// newһ��studentʵ�������ڽ��ս����
				s.setId(rs.getInt("id"));// ȡ��id��д��studentʵ����
				s.setName(rs.getString("name"));// ȡ��name��д��studentʵ����
				s.setMyclass(rs.getString("myclass"));// ȡ��myclass��д��studentʵ����
				s.setScore(rs.getDouble("score"));// ȡ��socre��д��studentʵ����

				allStu.add(s);// ������ӵ�������
			}
		} catch (SQLException e) {
			System.err.println("���ݰ༶��ѯѧ��ʧ��,��鿴����ԭ��!");
			e.printStackTrace();
		}
		return allStu;
	}

	/**
	 * ���ݷ�����ѯ,����һ��ѧ���б�
	 */
	public List<Student> findByScore(int score) {
		Connection conn = null;// �������ݿ�
		PreparedStatement ps = null;// Ԥ����
		ResultSet rs = null;// �����--
		List<Student> allStu = null;// �����õĽ�����б���

		try {
			conn = JDBCUtils.getConnection();// ������ݿ�����
			String sql = "select * from t_student where score < ?";// SQL���
			ps = conn.prepareStatement(sql);// ��SQL���ʵ����prepareStatement
			ps.setInt(1, score);// �����score
			rs = ps.executeQuery();// ִ�в�ѯ����ý����

			while (rs.next()) {// ��������Ϊ��
				if (allStu == null) {// ֻ��Ҫ��һ��ʵ����,
					allStu = new ArrayList<Student>();// ��arrayʵ����
				}

				Student s = new Student();// newһ��studentʵ�������ڽ��ս����
				s.setId(rs.getInt("id"));// ȡ��id��д��studentʵ����
				s.setName(rs.getString("name"));// ȡ��name��д��studentʵ����
				s.setMyclass(rs.getString("myclass"));// ȡ��myclass��д��studentʵ����
				s.setScore(rs.getDouble("score"));// ȡ��socre��д��studentʵ����

				allStu.add(s);// ������ӵ�������
			}
		} catch (SQLException e) {
			System.err.println("���ݷ�����ѯѧ��ʧ��,��鿴����ԭ��!");
			e.printStackTrace();
		}
		return allStu;
	}

	
	/**
	 * ����ѧ�Ų�ѯѧ��
	 */
	public Student findById(int sid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		Student stu = null;

		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from t_student where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sid);// �����id

			rs = ps.executeQuery();

			if (rs.next()) {

				stu = new Student();

				int id = rs.getInt("id");
				String name = rs.getString("name");
				String myclass = rs.getString("myclass");
				double socre = rs.getDouble("score");

				stu.setId(id);
				stu.setName(name);
				stu.setMyclass(myclass);
				stu.setScore(socre);

			}

		} catch (SQLException e) {
			System.err.println("����ѧ�Ų�ѯѧ��ʧ��,��鿴����ԭ��!");
			e.printStackTrace();
		}
		return stu;// ����һ��ѧ��
	}

	/**
	 * ����������ѯѧ��
	 */
	public List<Student> findByName(String sname) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Student> allStu = null;

		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from t_student where name like ";
			sql = sql + "'%"+sname+"%'";//֧����ģ����ѯ
			ps = conn.prepareStatement(sql);
			//ps.setString(1, sname);

			rs = ps.executeQuery();

			while (rs.next()) {// ��������Ϊ��
				if (allStu == null) {// ֻ��Ҫ��һ��ʵ����,
					allStu = new ArrayList<Student>();// ��arrayʵ����
				}

				Student s = new Student();// newһ��studentʵ�������ڽ��ս����
				s.setId(rs.getInt("id"));// ȡ��id��д��studentʵ����
				s.setName(rs.getString("name"));// ȡ��name��д��studentʵ����
				s.setMyclass(rs.getString("myclass"));// ȡ��myclass��д��studentʵ����
				s.setScore(rs.getDouble("score"));// ȡ��socre��д��studentʵ����

				allStu.add(s);// ������ӵ�������
			}
		} catch (SQLException e) {
			System.err.println("����������ѯѧ��ʧ��,��鿴����ԭ��!");
			e.printStackTrace();
		}
		return allStu;
	}

	/**
	 * ����һ��ѧ��,��������,�༶,�ɼ�,ѧ����������
	 */
	public int add(Student student) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			conn = JDBCUtils.getConnection();
			String sql = "insert into t_student(name,myclass,score) values(?,?,?)";
			ps = conn.prepareStatement(sql);

			ps.setString(1, student.getName());
			ps.setString(2, student.getMyclass());
			ps.setDouble(3, student.getScore());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * �޸�һ��ѧ�� ���ݴ����ѧ����,��ѧ��,�޸���������Ϣ(ѧ��������)
	 */
	public int modify(Student student) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			conn = JDBCUtils.getConnection();
			String sql = "update t_student set name=?,myclass=?,score=? where id = ?";
			ps = conn.prepareStatement(sql);

			ps.setString(1, student.getName());
			ps.setString(2, student.getMyclass());
			ps.setDouble(3, student.getScore());
			ps.setInt(4, student.getId());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			System.err.println("���ѧ��ʧ��,��鿴����ԭ��!");
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * ɾ��һ��ѧ��.���ݴ����ѧ�Ų���
	 */
	public int delete(int sid) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			conn = JDBCUtils.getConnection();
			String sql = "delete from t_student where id = ?";
			ps = conn.prepareStatement(sql);

			ps.setInt(1, sid);

			result = ps.executeUpdate();

		} catch (SQLException e) {
			System.err.println("ɾ��ѧ��ʧ��,��鿴����ԭ��!");
			e.printStackTrace();
		}
		return result;
	}

	
	/**
	 * ����ѧ�������������
	 */
	@Override
	public int findTotalCount() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int totalCount = 0;
		
		try{
			conn = JDBCUtils.getConnection();
			//������䷵��һ��,��ΪtotalCount,ֵΪ���е�����,����������ResultSet�������ȡֵ
			String sql = "select count(*) as totalCount from t_student ";
			ps = conn.prepareStatement(sql);
						
			rs = ps.executeQuery();
			
			if(rs.next()){
				totalCount = rs.getInt("totalCount");
			}
			
			
		}catch(SQLException e){
			System.err.println("����ѧ���б���������ʧ��,��鿴����ԭ��!");
			e.printStackTrace();
		}
		
		return totalCount;
	}

	/**
	 * ѧ���б��ҳ��ѯ,����һ���Ѿ���ҳ��ѧ���б�
	 */
	@Override
	public List<Student> findOnePage(int pageIndex, int pageSize) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Student> stuList = null;// �����õĽ�����б���
		
		try{
			conn = JDBCUtils.getConnection();
			//��ҳ��ѯ limit ��ʼ���� ��ʾ������
			String sql = "select * from t_student limit ?,?";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, (pageIndex - 1)* pageSize);//��ʼ���� = (��ǰҳ�� - 1) * ÿҳ��ʾ������
			ps.setInt(2, pageSize);	//ÿҳ��ʾ������		
			
			rs = ps.executeQuery();
			
			while (rs.next()) {// ��������Ϊ��
				if (stuList == null) {// ֻ��Ҫ��һ��ʵ����,
					stuList = new ArrayList<Student>();// ��arrayʵ����
				}

				Student s = new Student();// newһ��studentʵ�������ڽ��ս����
				s.setId(rs.getInt("id"));// ȡ��id��д��studentʵ����
				s.setName(rs.getString("name"));// ȡ��name��д��studentʵ����
				s.setMyclass(rs.getString("myclass"));// ȡ��myclass��д��studentʵ����
				s.setScore(rs.getDouble("score"));// ȡ��socre��д��studentʵ����

				stuList.add(s);// ������ӵ�������
			}
		}catch(SQLException e){
			System.err.println("ѧ���б��ҳ��ѯʧ��,��鿴����ԭ��!");
			e.printStackTrace();
		}
		return stuList;//����һ���Ѿ���ҳ��ѧ���б�
	}

}
