package web.component;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dispatcher.UI;

@WebServlet({ "/ProductServlet", "/product" })
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String next ="main.jsp";
		String view = request.getParameter("view");
		if (view != null) {
			 UI.build(request, view);
		}
		RequestDispatcher rd = request.getRequestDispatcher(next);
		rd.forward(request, response);
	}

}
