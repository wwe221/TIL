package web.dispatcher;

import javax.servlet.http.HttpServletRequest;

public class UI {
	// make ui
	public static void build(HttpServletRequest request, String view) {
		if (view.equals("login")) {
			request.setAttribute("navi", Navi.login);
			request.setAttribute("center", "login");
		} else if (view.equals("register")) {
			request.setAttribute("navi", Navi.register);
			request.setAttribute("center", "register");
		} else if (view.equals("about")) {
			request.setAttribute("navi", Navi.about);
			request.setAttribute("center", "about");
		} else if (view.equals("useradd")) {
			request.setAttribute("navi", Navi.useradd);
			request.setAttribute("center", "user/add");
		} else if (view.equals("userlist")) {
			request.setAttribute("navi", Navi.userlist);
			request.setAttribute("center", "user/list");
		} else if (view.equals("userdetail")) {
			request.setAttribute("navi", Navi.userdetail);
			request.setAttribute("center", "user/detail");
		} else if (view.equals("userupdate")) {
			request.setAttribute("navi", Navi.userupdate);
			request.setAttribute("center", "user/update");
		} else if (view.equals("productadd")) {
			request.setAttribute("navi", Navi.productadd);
			request.setAttribute("center", "product/add");
		} else if (view.equals("productlist")) {
			request.setAttribute("navi", Navi.productlist);
			request.setAttribute("center", "product/list");
		}else if (view.equals("productdetail")) {
			request.setAttribute("navi", Navi.productdetail);
			request.setAttribute("center", "product/detail");
		} else if (view.equals("productupdate")) {
			request.setAttribute("navi", Navi.productupdate);
			request.setAttribute("center", "product/update");
		} 
	}

}
