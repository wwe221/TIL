package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ui.Navi;
@Controller
public class ProductController {
	@RequestMapping("/productadd.mc")
	public ModelAndView pa() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "product/add");
		mv.addObject("navi", Navi.productadd);
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/productlist.mc")
	public ModelAndView pl() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "product/list");
		mv.addObject("navi", Navi.productlist);
		mv.setViewName("main");
		return mv;
	}
}
