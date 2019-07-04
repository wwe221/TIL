package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
		mv.setViewName("user/list");
		return mv;
	}
}
