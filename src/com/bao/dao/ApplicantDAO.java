package com.bao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bao.domain.Student;
import com.bao.utils.JDBCUtils;

/**
 * ��¼��Ϣ��֤
 */
public class ApplicantDAO {
	/**
	 * �����˺ź�������֤��¼,���ص�¼�˺�.��Ϊ��,��֤����¼�ɹ�
	 */
	public String login(String username, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String loginUsername = null;

		try {
			conn = JDBCUtils.getConnection();
			String sql = "select username from idinfo where username = ? and password = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);// ������˻�������
			ps.setString(2, password);

			rs = ps.executeQuery();

			if (rs.next()) {
				loginUsername = rs.getString("username");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginUsername;// ����һ��ѧ�����˺�
	}

	/**
	 * �����˺�,�޸�����
	 */
	public void SaveUpdate(String username,String newpassword) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE idinfo SET password = ? WHERE username = ?";
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, newpassword);
			ps.setString(2, username);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �����˺ŷ�������,������֤�޸�����
	 */
	public String isUpdate(String username) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String password = null;

		try {
			conn = JDBCUtils.getConnection();
			String sql = "select password from idinfo where username = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);// ������˻�

			rs = ps.executeQuery();

			if (rs.next()) {
				password = rs.getString("password");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return password;// ����һ������
	}

	/**
	 * ��֤�˺��Ƿ��ѱ�ע�� �����û�������˺�,��ѯ����,�н�������Ѿ����ڴ�����,��ʾ
	 */
	public boolean isExistUsername(String username) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM idinfo WHERE username=?";// ��ѯ����
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next())
				return true;// ����Ϊtrue
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * ע����Ϣ���� �����û�������˺ź�����,���뵽����
	 */
	public void save(String username, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO idinfo(username,password) VALUES(?,?)";
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
