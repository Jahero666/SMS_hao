package com.bao.utils;
import java.io.File;

import javax.servlet.jsp.jstl.core.Config;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.bao.model.JDBCInfo;


/**
 * ��ȡXML�����ļ��е�����,����һ���Ѿ���װ�õ�JDBCInfo����,�����������ݿ�
 */
public class XmlConfigReader {
	SAXReader reader = new SAXReader();
	JDBCInfo info = new JDBCInfo();

	public XmlConfigReader() {
		try {
			//Document doc = reader.read(ClassLoader.getSystemResourceAsStream("config.xml"));// ��Ҫ�þ���·��
			// ����װ��������ȡ�ļ�,��ΪSRCĿ¼�����ļ���java�����ն�����뵽classes��bin��
			Document doc = reader.read(getClass().getClassLoader().getResourceAsStream("config.xml"));
			Element root = doc.getRootElement();// ����Ԫ��
			Element dbinfo = root.element("db-info");// ����Ԫ��
			Element driverNameElt = dbinfo.element("drivername");
			Element urlElt = dbinfo.element("url");
			Element userNameElt = dbinfo.element("username");
			Element passwordElt = dbinfo.element("password");

			info.setDrivername(driverNameElt.getStringValue());
			info.setUrl(urlElt.getStringValue());
			info.setUsername(userNameElt.getStringValue());
			info.setPassword(passwordElt.getStringValue());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �˷��������ڷ���һ���Ѿ�����XMLԪ�صĶ���
	 * 
	 * @return
	 */
	public JDBCInfo getJdbcInfo() {
		return info;
	}
}

