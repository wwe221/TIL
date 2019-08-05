package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class UserController {

	@RequestMapping("/useradd.mc")
	public ModelAndView useradd() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/add");
		return mv;
	}

	@RequestMapping("/userlist.mc") 
	public ModelAndView ul() {
		ModelAndView mv = new ModelAndView();
		int a = 1/0;
		mv.setViewName("user/list");
		return mv;
	}
}
