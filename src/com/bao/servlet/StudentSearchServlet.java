package com.bao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bao.dao.IStudentDao;
import com.bao.dao.impl.StudentDaoJdbcImpl;
import com.bao.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ������������ѧ����servlet
 */
@WebServlet("/StudentSearchServlet")
public class StudentSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentSearchServlet() {
		super();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1.������������ı���
		req.setCharacterEncoding("utf-8");

		// 2.�õ��������
		String option = req.getParameter("option");// �����б�select��ѡ�����
		String keywords = req.getParameter("keywords");// ������Ĳ���

		// 3.����dao���ҵ���߼�:ɾ���ƶ�ѧ�ŵ�ѧ����¼
		IStudentDao stuDao = new StudentDaoJdbcImpl();

		// �߼��ж�
		if ("sid".equals(option)) {// ��ѧ������
			int id = Integer.parseInt(keywords);
			Student student = stuDao.findById(id);
			List<Student> stuList = new ArrayList<Student>();// ��arrayʵ����
			stuList.add(student);
			if (student == null) {
				stuList = null;
			}
			req.setAttribute("stuList", stuList);
		}
		if ("sname".equals(option)) {// ����������
			List<Student> stuList = stuDao.findByName(keywords);
			req.setAttribute("stuList", stuList);
		}
		if ("myclass".equals(option)) {// �ǰ༶����
			List<Student> stuList = stuDao.findByClass(keywords);
			req.setAttribute("stuList", stuList);
		}
		if ("score".equals(option)) {// �Ƿ�������
			int score = Integer.parseInt(keywords);
			List<Student> stuList = stuDao.findByScore(score);
			req.setAttribute("stuList", stuList);
		}
		// 5.�Ѳ�ѯ����洢��request������Ȼ����ת����Ӧ��ҳ��
		req.getRequestDispatcher("admin/search.jsp").forward(req, resp);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
