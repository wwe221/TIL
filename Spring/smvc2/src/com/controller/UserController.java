package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ui.Navi;
@Controller
public class UserController {	       
	ModelMap m = new ModelMap();
	@RequestMapping("/useradd.mc")
	public ModelAndView useradd() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "user/add");		
		mv.addObject("navi", Navi.useradd);
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/userlist.mc") 
	public ModelAndView ul() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "user/list");
		mv.addObject("navi", Navi.userlist);
		mv.setViewName("main");
		return mv;
	}
}
