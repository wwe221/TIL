package com.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frame.Biz;
import com.user.UserBiz;
import com.vo.User;

@WebServlet({ "/UserServlet", "/user" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Biz<String, User> biz;

	public UserServlet() { // 메모리에 올라갈때, 최초 실행때만 한번 생성한다.
		biz = new UserBiz();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String next = "";
		if (cmd.equals("add")) {
			next = "user/add";
		} else if (cmd.equals("addimpl")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			try {
				biz.register(new User(id, pwd, name));
				request.setAttribute("rid", id);
				next = "user/r_ok";
			} catch (Exception e) {
				next = "user/r_fail";
			}
		} else if (cmd.equals("list")) {
			try {
				ArrayList<User> list = biz.get();
				request.setAttribute("ulist", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
			next = "user/list";
		} else if (cmd.equals("detail")) {
			String id = request.getParameter("id");
			User u = null;
			try {
				u = biz.get(id);
				request.setAttribute("ud", u);
				next = "user/detail";
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (cmd.equals("delete")) {
			String id = request.getParameter("id");
			try {
				biz.remove(id);
				response.sendRedirect("req?type=user&cmd=list");
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (cmd.equals("update")) {
			String id = request.getParameter("id");
			User u = null;
			try {
				u = biz.get(id);
				request.setAttribute("uu", u);
				next = "user/update";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (cmd.equals("updateimpl")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");			
			try {
				biz.modify(new User(id, pwd, name));
				response.sendRedirect("req?type=user&cmd=detail&id="+id);
				return;
			} catch (Exception e) {			
				e.printStackTrace();
				next= "user/r_fail";
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(next + ".jsp");
		rd.forward(request, response);
	}

}
