package web.component;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.frame.Biz;
import com.user.UserBiz;
import com.vo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({ "/LoginServlet", "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   Biz<String , User> biz;
	    public LoginServlet() {
	        biz = new UserBiz();
	    }
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			if(session != null) {
				session.invalidate();
				//
			}
			response.sendRedirect("index.jsp");
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");		
			String center="";
			User u = null;
			try {
				u = biz.get(id);
				if(u.getPwd().equals(pwd)) {
					HttpSession session = request.getSession();
					session.setAttribute("loginuser", u);					
					center = "loginok";
					//session.setMaxInactiveInterval(3000); 을 통해서 자동로그아웃 시간을 설정 할 수 있다.
				//서버측에 사용자가 로그인 했음을 알리는 flag를 꽂는다!
				//이 값은 ${} 로 접근 할 수 있다.
				}else {
					center = "loginfail";				
				}
			} catch (Exception e) {
				center = "loginfail";
				e.printStackTrace();
			}
			request.setAttribute("center", center);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);		
		}

}
