package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.Post;

@Controller
public class PostController {
	@Resource(name = "pbiz")
	Biz<Integer, Post> biz;
	@RequestMapping("/postadd.mc")
	public ModelAndView uadd() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "post/add");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/postaddimpl.mc")
	public ModelAndView uaddc(ModelAndView mv, Post u) {
		try {
			biz.insert(u);

		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/postlist.mc")
	public ModelAndView ulist() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Post> list = null;
		try {
			list = biz.select();
		} catch (Exception e) {
			e.printStackTrace();
		}

		mv.addObject("center", "post/list");
		mv.addObject("ulist", list);
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/postdetail.mc")
	public ModelAndView pdetail(ModelAndView mv, Integer id) {
		Post p = null;
		try {
			p = biz.select(id);
			mv.addObject("ud", p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("navi", Navi.productlist);
		mv.addObject("center", "post/detail");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/postdelete.mc")
	public String pdel(ModelAndView mv, Integer id) {
		try {
			biz.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:postlist.mc";
	}
	@RequestMapping("/postupdate.mc")
	public ModelAndView pup(ModelAndView mv, Integer id) {
		Post u = null;
		try {
			u = biz.select(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("navi", Navi.productlist);
		mv.addObject("uu",u);
		mv.addObject("center", "post/update");
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/postupdateimpl.mc")
	public String pupimp(ModelAndView mv, Post p) {		
		try {
			biz.update(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:postdetail.mc?id="+p.getId();
	}

}
