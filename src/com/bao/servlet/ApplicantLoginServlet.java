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
import javax.servlet.http.HttpSession;

import com.bao.dao.ApplicantDAO;
import com.bao.dao.IStudentDao;
import com.bao.dao.impl.StudentDaoJdbcImpl;
import com.bao.domain.Student;

/**
 * ��¼����ʵ��
 */
@WebServlet("/ApplicantLoginServlet")
public class ApplicantLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ApplicantLoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �����������Ӧ����
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// ��ȡ�������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String verifyCode = request.getParameter("verifyCode");
		// �ж���֤���Ƿ���ȷ
		String sessionValidateCode = (String) request.getSession().getAttribute("SESSION_VALIDATECODE");
		if (!sessionValidateCode.equals(verifyCode)) {
			out.print("<script type='text/javascript'>");
			out.print("alert('����ȷ������֤�룡');");
			out.print("window.location='login.html';");
			out.print("</script>");
		}
		// ��¼��֤
		ApplicantDAO dao = new ApplicantDAO();
		String loginUsername = dao.login(username, password);
		if (loginUsername != null) {// �����ص��˺Ų�Ϊ��,���¼�ɹ�,����ѯ����ѧ����Ϣ�����������,��ת��ѧ���б�ҳ��
			IStudentDao stuDao = new StudentDaoJdbcImpl();
			List<Student> stuList = stuDao.findAll();

			// ���û�������session����ͷ���ļ���ʾ�û���
			HttpSession session = request.getSession();
			session.setAttribute("SESSION_USERNAME", username);
			// ����ѯ����ѧ����Ϣ�����������,��ת����ҳ
			//request.getRequestDispatcher("admin/index.jsp").forward(request, response);
			response.sendRedirect("admin/index.jsp");
		} else {// ������ʾlogin.html
			out.print("<script type='text/javascript'>");
			out.print("alert('�û���������������������룡');");
			out.print("window.location='login.html';");
			out.print("</script>");
		}
	}

}
