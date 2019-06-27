package com.sds;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/HelloServlet", "/hello" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet Start...");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String h = request.getParameter("dept");
		String gen= request.getParameter("gen");
		String []cl = request.getParameterValues("cl");
		
		System.out.println(id + " " + pwd + " " + h + " " + gen);
		System.out.println(cl);		
		request.setAttribute("id", id);
		request.setAttribute("pwd", pwd);
		request.setAttribute("dept", h);
		request.setAttribute("gen", gen);
		request.setAttribute("cl", cl);
		
		RequestDispatcher rd = request.getRequestDispatcher("ok.jsp");
		rd.forward(request, response);
	}

	
	
	
	
	
	
	
	
	
	
	
}
