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


@Controller
public class MainController {

	@RequestMapping("/main.sh")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/login.sh")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "login");
		mv.addObject("navi", Navi.login);
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/movie.sh")
	public ModelAndView movie() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "movie");
		mv.addObject("navi", Navi.login);
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/pe.sh")
	public ModelAndView pe() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "pe");
		mv.addObject("navi", Navi.login);
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/music.sh")
	public ModelAndView music() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "music");
		mv.addObject("navi", Navi.login);
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/drama.sh")
	public ModelAndView drama() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "drama");
		mv.addObject("navi", Navi.login);
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/write.sh")
	public ModelAndView write() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "addreview");
		mv.addObject("navi", Navi.login);
		mv.setViewName("main");
		return mv;
	}
	
}
