package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.Star;

@Controller
public class StarController {
	@Resource(name = "sbiz")
	Biz<Integer, Star> biz;
	@RequestMapping("/staradd.mc")
	public ModelAndView uadd() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "star/add");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/staraddimpl.mc")
	public ModelAndView uaddc(ModelAndView mv, Star u) {
		try {
			biz.insert(u);

		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/starlist.mc")
	public ModelAndView ulist() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Star> list = null;
		try {
			list = biz.select();
		} catch (Exception e) {
			e.printStackTrace();
		}

		mv.addObject("center", "star/list");
		mv.addObject("ulist", list);
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/stardetail.mc")
	public ModelAndView pdetail(ModelAndView mv, Integer id) {
		Star p = null;
		try {
			p = biz.select(id);
			mv.addObject("ud", p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("navi", Navi.productlist);
		mv.addObject("center", "star/detail");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/stardelete.mc")
	public String pdel(ModelAndView mv, Integer id) {
		try {
			biz.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:starlist.mc";
	}
	@RequestMapping("/starupdate.mc")
	public ModelAndView pup(ModelAndView mv, Integer id) {
		Star u = null;
		try {
			u = biz.select(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("navi", Navi.productlist);
		mv.addObject("uu",u);
		mv.addObject("center", "star/update");
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/starupdateimpl.mc")
	public String pupimp(ModelAndView mv, Star p) {		
		try {
			biz.update(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:stardetail.mc?id="+p.getId();
	}

}
