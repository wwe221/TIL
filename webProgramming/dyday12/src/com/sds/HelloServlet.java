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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet Start...");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println(id +" "+pwd);		
/*		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>LOGIN OK</h1>");
		out.println("<h1>"+id+"님 하이. </h1>");
		out.close();*/
		//response.sendRedirect("ok.jsp?id="+id+"%pwd="+pwd);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(5);
		ArrayList<Item> list2 = new ArrayList<Item>();
		list2.add(new Item("I1",10));
		list2.add(new Item("I2",20));
		list2.add(new Item("I3",40));
		list2.add(new Item("I4",60));
		list2.add(new Item("I5",80));
		list2.add(new Item("I6",90));
		list2.add(new Item("I7",100));
		request.setAttribute("list2", list2);
		request.setAttribute("list1", list);
		request.setAttribute("id", id);
		request.setAttribute("pwd", pwd);
		request.setAttribute("cnt", 8);
		RequestDispatcher rd = request.getRequestDispatcher("ok.jsp");
		rd.forward(request, response);
	}

}
