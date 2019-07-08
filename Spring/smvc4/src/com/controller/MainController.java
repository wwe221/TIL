package com.controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Services;
import com.vo.Product;
import com.vo.User;

@Controller
public class MainController {
	@Resource(name = "ubiz")
	Services<String, User> biz;
	@Resource(name = "pbiz")
	Services<Integer, Product> pbiz;

	@RequestMapping("/main.mc")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/login.mc")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "login");
		mv.addObject("navi", Navi.login);
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/loginimpl.mc")
	public ModelAndView loginimpl(ModelAndView mv, HttpServletRequest request, HttpSession session) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println(id + "" + pwd);
		try {
			User dbuser = biz.select(id);
			System.out.println(dbuser);
			if (pwd.equals(dbuser.getPwd())) {
				session.setAttribute("loginuser", dbuser);
				mv.addObject("center", "loginok");
			} else {
				mv.addObject("center", "loginfail");
			}
		} catch (Exception e) {
			e.getStackTrace();
			mv.addObject("center", "loginfail");
		}
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/logout.mc")
	public ModelAndView logout(ModelAndView mv, HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/aboutus.mc")
	public ModelAndView aboutus() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "aboutus");
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/register.mc")
	public ModelAndView regit() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "register");
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/pchart.mc")
	@ResponseBody
	public void pdata(HttpServletResponse response) {
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/json;charset=UTF-8");
		ArrayList<Product> list = new ArrayList<Product>();
		JSONArray ja = new JSONArray();
		PrintWriter pt;
		try {
			list = pbiz.select();
			int l = list.size();
			for(int i=0;i<l;i++) {
				JSONObject jo = new JSONObject();
				jo.put("name",list.get(i).getName());
				jo.put("y",list.get(i).getPrice());
				ja.add(jo);
			}			
			pt = response.getWriter();
			pt.print(ja.toJSONString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
