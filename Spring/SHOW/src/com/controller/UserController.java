package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.User;

@Controller
public class UserController {
	@Resource(name = "ubiz")
	Biz<String, User> biz;	
	
	@RequestMapping("/register.sh")
	public ModelAndView uadd() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "register");
		mv.addObject("navi", Navi.useradd);
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/useraddimpl.sh")
	public ModelAndView uaddc(ModelAndView mv, User u) {	
		try {
			System.out.println(u);
			biz.insert(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/userlist.mc")
	public ModelAndView ulist() {
		ModelAndView mv = new ModelAndView();
		ArrayList<User> list = null;
		try {
			list = biz.select();
		} catch (Exception e) {
			e.printStackTrace();
		}

		mv.addObject("center", "user/list");
		mv.addObject("ulist", list);
		mv.addObject("navi", Navi.userlist);
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/userdetail.mc")
	public ModelAndView pdetail(ModelAndView mv, String id) {
		User p = null;
		try {
			p = biz.select(id);
			mv.addObject("ud", p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("navi", Navi.productlist);
		mv.addObject("center", "user/detail");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/userdelete.mc")
	public String pdel(ModelAndView mv, String id) {
		try {
			biz.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:userlist.mc";
	}
	
	// UserUpdate
	@RequestMapping("/userupdate.sh")
	public ModelAndView userupdate(ModelAndView mv, String id) {
		User user = null;
		
		try {
			user = biz.select(id);
			System.out.println(user);
			mv.addObject("userupdate",user);
			mv.addObject("center", "user/update");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/userupdateimpl.sh")
	public String userupdateimpl(ModelAndView mv, User user) {		
		try {
			biz.update(user);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:userdetail.sh?id="+user.getId(); 
		
	}

}
