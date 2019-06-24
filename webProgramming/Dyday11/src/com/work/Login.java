package com.work;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet({ "/Login", "/login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginServlet Called");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");		
		String[] ids = { "abcd", "qwer", "zxcv", "asdf" };
		String url = "";
		for (int i = 0; i < ids.length; i++) {
			if (id.equals(ids[i]) && pwd.equals("1111")) {
				url = "init.html";
			} else {
				url = "loginfail.html";
			}
		}
		response.sendRedirect(url);
	}

}
