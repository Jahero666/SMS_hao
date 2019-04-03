package com.bao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
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
 * ��� ѧ����servlet
 */
@WebServlet("/StudentAddServlet")
public class StudentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public StudentAddServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1.������������ı���
		req.setCharacterEncoding("utf-8");
		
		//2.�õ��������
		String name = req.getParameter("name");
		String myclass = req.getParameter("myclass");
		String sScore = req.getParameter("score");
		
		double score = Double.parseDouble(sScore);
		
		//3.����dao���ҵ���߼�:ɾ���ƶ�ѧ�ŵ�ѧ����¼
		IStudentDao stuDao = new StudentDaoJdbcImpl();
		Student student = new Student(name,myclass,score);
		stuDao.add(student);
		
		//4.������Ӧ���ҳ��
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		out.print("<script type='text/javascript'>");
		out.print("alert('��ӳɹ�������ת��ѧ���б�ҳ�棡');");
		out.print("parent.location.reload();");
		out.print("</script>");
	}

}
