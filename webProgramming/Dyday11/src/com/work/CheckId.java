package com.work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Check", urlPatterns = { "/Check", "/checkid", "/check" })
public class CheckId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// chekc id
		String id = request.getParameter("id");
		String result = "0";
		if (id.length() < 4) {
			result = "0";
		} else if (id.length() > 12) {
			result = "2";
		}
		else
			result= "1";
		PrintWriter out = response.getWriter();
		out.print(result);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// check id dupl
		String id = request.getParameter("id");
		String result = "1";
		String[] ids = { "abcd", "qwer", "zxcv", "asdf" };
		for (int i = 0; i < ids.length; i++) {
			if (id.equals(ids[i])) {
				result = "0";			
			}
		}
		PrintWriter out = response.getWriter();
		out.print(result);
		out.close();
	}

}
