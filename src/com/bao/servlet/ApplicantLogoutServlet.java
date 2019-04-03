package com.bao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ϵͳ�˳���������Servlet
 */
@WebServlet("/ApplicantLogoutServlet")
public class ApplicantLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ApplicantLogoutServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ����û��Ự��ʹ��ʧЧ
		HttpSession session = request.getSession();
		session = null;//���
		request.getSession().invalidate();//����
		// �����ض�����վ��ҳ
		response.sendRedirect("login.html");
	}

}
