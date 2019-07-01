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
import com.oreilly.servlet.MultipartRequest;
import com.product.ProductBiz;
import com.vo.Product;
import com.vo.User;

import web.dispatcher.UI;

@WebServlet({ "/ProductServlet", "/product" })
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Biz<Integer, Product> biz;

	public ProductServlet() {
		biz = new ProductBiz();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String next = "index.jsp";
		String view = request.getParameter("view");
		String cmd = request.getParameter("cmd");
		if (view != null) {
			UI.build(request, view);
		} else if (cmd != null) {
			if (cmd.equals("productadd")) {
				MultipartRequest mr = new MultipartRequest(request,
						"C:\\Users\\student\\KH\\TIL\\webProgramming\\Dyday134\\web\\img\\", 1024 * 1024 * 100,
						"UTF-8");
				String name = mr.getParameter("name");
				double price = Double.parseDouble(mr.getParameter("price"));
				String imgname = mr.getOriginalFileName("imgname");
				try {
					biz.register(new Product(name, price, imgname));
					response.sendRedirect("user.do?&cmd=productlist");
					return;
				} catch (Exception e) {
					next = "user/r_fail";
				}
			} else if (cmd.equals("productlist")) {
				ArrayList<Product> list = new ArrayList<>();
				try {
					list = biz.get();
					request.setAttribute("plist", list);
					UI.build(request, cmd);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (cmd.equals("productdetail")) {
				Product u = new Product();
				int id = Integer.parseInt(request.getParameter("id"));
				try {
					u = biz.get(id);
					request.setAttribute("pd", u);
					UI.build(request, cmd);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (cmd.equals("productdelete")) {
				int id = Integer.parseInt(request.getParameter("id"));
				try {
					biz.remove(id);
					response.sendRedirect("product.do?&cmd=productlist");
					return;
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (cmd.equals("productupdate")) {
				int id = Integer.parseInt(request.getParameter("id"));
				Product u = null;
				try {
					u = biz.get(id);
					request.setAttribute("pu", u);
					UI.build(request, cmd);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (cmd.equals("productupdateimple")) {
				MultipartRequest mr = new MultipartRequest(request,
						"C:\\Users\\student\\KH\\TIL\\Dyday133\\web\\img", 1024 * 1024 * 100,
						"UTF-8");
				String name = mr.getParameter("name");
				int id = Integer.parseInt(mr.getParameter("id"));
				double price = Double.parseDouble(mr.getParameter("price"));
				String imgname = mr.getOriginalFileName("imgname");
				String newimgname = mr.getOriginalFileName("newimgname");		
				if (newimgname == null || newimgname.equals("")) {
					try {
						biz.modify(new Product(id, name, price, imgname));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					try {
						biz.modify(new Product(id, name, price, newimgname));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(next);
		rd.forward(request, response);
	}

}
