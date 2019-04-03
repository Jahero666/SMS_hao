package com.bao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bao.dao.IStudentDao;
import com.bao.dao.impl.StudentDaoJdbcImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ɾ��һ��ѧ����servlet
 */
@WebServlet("/StudentDeleteServlet")
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentDeleteServlet() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//1.������������ı���
		req.setCharacterEncoding("utf-8");
		
		//2.�õ��������
		String sId = req.getParameter("id");
		int id = Integer.parseInt(sId);
		
		//3.����dao���ҵ���߼�:ɾ���ƶ�ѧ�ŵ�ѧ����¼
		IStudentDao stuDao = new StudentDaoJdbcImpl();
		stuDao.delete(id);
		
		//4.������Ӧ���ҳ��
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		out.print("<script type='text/javascript'>");
		out.print("alert('ɾ���ɹ�������ת��ѧ���б�ҳ�棡');");
		out.print("parent.location.reload();");
		out.print("</script>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
