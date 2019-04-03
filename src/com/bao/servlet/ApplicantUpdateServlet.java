package com.bao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 * �޸����빦��ʵ��
 * �����˺�,�޸�����
 */
@WebServlet("/ApplicantUpdateServlet")
public class ApplicantUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ApplicantUpdateServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �����������Ӧ����
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// ��ȡ�������
		String username = request.getParameter("username");
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		
		// ��¼��֤
		ApplicantDAO dao = new ApplicantDAO();
		String password = dao.isUpdate(username);
		if (password.equals(oldpassword)) {//�Ƚ������Ƿ���ȷ
			// ��session����
			HttpSession session = request.getSession();
			session.setAttribute("SESSION_USERNAME", username);
			dao.SaveUpdate(username,newpassword);//�޸�����
			out.print("<script type='text/javascript'>");
			out.print("alert('�޸�����ɹ���');");
			out.print("parent.location.reload();");
			out.print("</script>");
		} else {// ������ʾlogin.html
			out.print("<script type='text/javascript'>");
			out.print("alert('ԭʼ����������������룡');");
			out.print("window.location='admin/pass.jsp';");
			out.print("</script>");
		}
	}


}
