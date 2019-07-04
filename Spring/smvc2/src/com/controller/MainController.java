package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
public class MainController {
	@RequestMapping("/main.mc")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/login.mc")	
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center","login");		
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping(value="/loginmethod.mc" ,method=RequestMethod.POST)	
	public ModelAndView loginmethod(String id, String pwd) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center","login");
		System.out.println(id +" "+ pwd);
		mv.setViewName("main");
		return mv;
	}
}
