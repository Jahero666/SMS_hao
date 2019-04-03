package com.bao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bao.model.JDBCInfo;

/**
 * ���ݿ����Ӻ͹ر�,ͳһ�ŵ��������,�����������
 */
public class JDBCUtils {
	
	public static Connection getConnection()
	{
		//��XML��ȡ���ݿ��ʵ����JDBCInfo
		JDBCInfo info = new XmlConfigReader().getJdbcInfo();		
		Connection con = null ;		
		try {		
			Class.forName(info.getDrivername());//��������
			String url = info.getUrl();//�XML��·��
			String username =  info.getUsername();//�˻�
			String password = info.getPassword();//����
			con = DriverManager.getConnection(url,username, password);//��ʽ����
			System.out.println("���ݿ����ӳɹ�");
		} catch (Exception e) {
			System.out.println("���ݿ�����ʧ��,��鿴����ԭ��:");
			e.printStackTrace();
		}		
		return con ;		
	}

	
	/**
	 * �ر�����
	 */
	public static void free(ResultSet rs, Statement sta , Connection con)
	{
		try {
			if(null != rs)
			{
				rs.close();
				rs = null ;
			}
			
			if(null != sta)
			{
				sta.close();
				sta = null ;
			}
			
			if(null != con)
			{
				con.close();
				con = null ;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}




