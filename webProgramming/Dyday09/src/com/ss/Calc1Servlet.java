package com.ss;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/Calc1Servlet", "/calc1" })
public class Calc1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Calc1Servlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		int n1= Integer.parseInt(num1);
		int n2= Integer.parseInt(num2);
		int result = n1 + n2 ;
		Writer out = response.getWriter();
		out.write("<h1>"+result+"</h1>");
		out.close();
	}

}
