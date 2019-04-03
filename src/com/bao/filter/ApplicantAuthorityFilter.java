package com.bao.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * /applicant/*--�Դ�Ŀ¼�������ļ��������
 */
@WebFilter(urlPatterns = { "/admin/*" }, 
servletNames = {
"com.bao.servlet.ApplicantUpdateServlet", 
"com.bao.servlet.StudentAddServlet", 
"com.bao.servlet.StudentDeleteServlet", 
"com.bao.servlet.StudentModifyServlet", 
"com.bao.servlet.StudentSearchServlet", 
"com.bao.servlet.StudentListServlet" }, //�����˵�servlet
initParams = { @WebInitParam(name = "loginPage", value = "login.html") }, //��ʼ����
dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD })//�� ֱ������ �� ת��  ����ģʽ ����
public class ApplicantAuthorityFilter implements Filter {
	private String loginPage = "login.html";
    public ApplicantAuthorityFilter() {
    }

	public void destroy() {
		this.loginPage = null;//filter����ʱ�ÿ�
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		// �жϱ����ص������û��Ƿ��ڵ�¼״̬
		if (session.getAttribute("SESSION_USERNAME") == null) {//δ��¼��ת������¼����
			// ��ȡ�����ص������ַ������
			String requestPath = req.getRequestURI();//�����ַ
			if (req.getQueryString() != null) {
				requestPath += "?" + req.getQueryString();//�������
			}
			// �������ַ���浽request������ת������¼ҳ��
			req.setAttribute("requestPath", requestPath);
			//request.getRequestDispatcher(loginPage)
					//.forward(request, response);
			resp.sendRedirect("../login.html");
			return;
		} else {
			chain.doFilter(request, response);//��¼�����,����Ŀ����Դ
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
				// ��ȡ����������ʱת���ҳ��
				loginPage = fConfig.getInitParameter("loginPage");
				if (null == loginPage) {
					loginPage = "/login.html";
				}
	}

}
