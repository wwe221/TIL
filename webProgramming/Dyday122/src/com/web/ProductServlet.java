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
import com.oreilly.servlet.MultipartRequest;
import com.product.ProductBiz;
import com.vo.Product;
import com.vo.User;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet({ "/ProductServlet", "/product" })
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Biz<Integer, Product> biz;

	public ProductServlet() {
		biz = new ProductBiz();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String next = "";
		if (cmd.equals("add")) {
			next = "product/add";
		} else if (cmd.equals("list")) {
			try {
				ArrayList<Product> list = biz.get();
				request.setAttribute("plist", list);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			next = "product/list";
		} else if (cmd.equals("addimpl")) {
			MultipartRequest mr = new MultipartRequest(request,
					"C:\\Users\\student\\KH\\TIL\\webProgramming\\Dyday122\\WebContent\\img", 1024 * 1024 * 100,
					"UTF-8");
			String name = mr.getParameter("name");
			double price = Double.parseDouble(mr.getParameter("price"));
			String imgname = mr.getOriginalFileName("imgname");
			try {
				
				biz.register(new Product(name, price, imgname));
				next = "product/r_ok";
			} catch (Exception e) {
				e.printStackTrace();
				next = "product/r_fail";
			}

		} else if (cmd.equals("detail")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Product p = null;
			try {
				p = biz.get(id);
				request.setAttribute("pd", p);
				next = "product/detail";
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (cmd.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));

			try {
				biz.remove(id);
				response.sendRedirect("req?type=product&cmd=list");
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (cmd.equals("update")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Product p = null;
			try {
				p = biz.get(id);
				request.setAttribute("pu", p);
				next = "product/update";
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (cmd.equals("updateimpl")) {
			MultipartRequest mr = new MultipartRequest(request,
					"C:\\Users\\student\\kh\\TIL\\webProgramming\\Dyday122\\WebContent\\img", 1024 * 1024 * 100,
					"UTF-8");
			int id = Integer.parseInt(mr.getParameter("id"));
			String name = mr.getParameter("name");
			double price = Double.parseDouble(mr.getParameter("price"));
			String imgname = mr.getParameter("imgname");
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
			response.sendRedirect("req?type=product&cmd=detail&id=" + id);
			return;

		}
		RequestDispatcher rd = request.getRequestDispatcher(next + ".jsp");
		rd.forward(request, response);
	}
}
