package web.component;

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

import web.dispatcher.UI;

@WebServlet({ "/UserServlet", "/user" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Biz<String, User> biz;

	public UserServlet() {
		biz = new UserBiz();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String next = "index.jsp";
		String view = request.getParameter("view");
		String cmd = request.getParameter("cmd");
		if (view != null) {
			UI.build(request, view);
		} else if (cmd != null) {
			if (cmd.equals("useradd")) {				
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String name = request.getParameter("name");
				try {
					biz.register(new User(id, pwd, name));
					request.setAttribute("rid", id);
					response.sendRedirect("user.do?&cmd=userlist");
					return;
				} catch (Exception e) {
					next = "user/r_fail";
				}
			} else if (cmd.equals("userlist")) {
				ArrayList<User> list = new ArrayList<User>();
				try {
					list = biz.get();
					request.setAttribute("ulist", list);
					UI.build(request, cmd);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (cmd.equals("userdetail")) {
				User u = new User();
				String id = request.getParameter("id");
				try {
					u = biz.get(id);
					request.setAttribute("ud", u);
					UI.build(request, cmd);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if (cmd.equals("userdelete")) {
				String id = request.getParameter("id");
				try {
					biz.remove(id);
					response.sendRedirect("user.do?&cmd=userlist");
					return;
				} catch (Exception e) {
					e.printStackTrace();
				}

			}else if (cmd.equals("userupdate")) {
				String id = request.getParameter("id");
				User u = null;
				try {
					u = biz.get(id);
					request.setAttribute("uu", u);
					UI.build(request, cmd);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if (cmd.equals("userupdateimple")) {
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String name = request.getParameter("name");
				try {
					biz.modify(new User(id, pwd, name));
					response.sendRedirect("user.do?&cmd=userlist");
					return;
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(next);
		rd.forward(request, response);
	}

}
