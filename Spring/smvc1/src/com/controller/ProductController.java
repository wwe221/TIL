package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ProductController {

	@RequestMapping("/productadd.mc")
	public ModelAndView pa() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/add");
		return mv;
	}

	@RequestMapping("/productlist.mc")
	public ModelAndView pl() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/list");
		return mv;
	}
}
