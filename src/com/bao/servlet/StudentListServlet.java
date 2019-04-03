package com.bao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bao.dao.IStudentDao;
import com.bao.dao.impl.StudentDaoJdbcImpl;
import com.bao.domain.*;

import com.bao.domain.Student;

import sun.awt.image.ImageWatched.Link;

@WebServlet("/StudentListServlet")
public class StudentListServlet extends HttpServlet {
	private int pageSize = 5;//ֱ���趨��һҳ��ʾ������Ϊ5��
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ʵ�ַ�ҳ��ʾ
		// 1. ������������ı���
		request.setCharacterEncoding("utf-8");

		// 2. ���ҳ���������� :Ҫ��ʾ��ҳ��pageIndex
		String sPageIndex = request.getParameter("pageIndex");
		if (sPageIndex == null || sPageIndex == "")//�ǵ�һ������,�򽫱�ҳ��Ϊ1
			sPageIndex = "1";
		int pageIndex = Integer.parseInt(sPageIndex);

		// 3. ����Dao��ѯ����ҳ��Ҫ�Ĳ���
		IStudentDao stuDao = new StudentDaoJdbcImpl();
		int totalCount = stuDao.findTotalCount();//ȡ����ҳ��
		List<Student> stuList = stuDao.findOnePage(pageIndex, pageSize);//���ݵ�ǰҳ����ÿҳ��ʾ������ȡ���Ѿ���ҳ��ѧ���б�

		// 4.��������Ĳ���,������ҳ����,���ڴ洢��request������,��stu_list.jsp���
		StudentPageBean<Student> pageBean = new StudentPageBean<Student>(pageIndex, pageSize, totalCount, stuList);
		pageBean.init();//��ʼ��,�õ��������,����ʵ����һҳ��һҳ�Ĺ���

		// 5.�ѷ�ҳ����洢��request������Ȼ����ת����Ӧ��book.jspҳ��
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("admin/list.jsp").forward(request,response);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
