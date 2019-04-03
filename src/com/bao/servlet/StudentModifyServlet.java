package com.bao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bao.dao.ApplicantDAO;
import com.bao.dao.IStudentDao;
import com.bao.dao.impl.StudentDaoJdbcImpl;
import com.bao.domain.Student;

/**
 * �޸ĵ�servlet
 */
@WebServlet("/StudentModifyServlet")
public class StudentModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public StudentModifyServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��������������ַ�����
		request.setCharacterEncoding("utf-8");

		// ����������
		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);

		String name = request.getParameter("name");
		String myclass = request.getParameter("myclass");

		String sScore = request.getParameter("score");
		double score = Double.parseDouble(sScore);

		// �ѱ�������װ��ʵ�������
		Student s = new Student(id, name, myclass, score);

		// ����Dao�޸���Ӧ�ļ�¼
		IStudentDao stuDao = new StudentDaoJdbcImpl();
		int flag = stuDao.modify(s);

		// 4.������Ӧ���ҳ��
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		out.print("<script type='text/javascript'>");
		out.print("alert('�޸ĳɹ�������ת��ѧ���б�ҳ�棡');");
		out.print("parent.location.reload();");
		out.print("</script>");
	}

}
