package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.Content;

@Controller
public class ContentController {
	@Resource(name = "cbiz")
	Biz<Integer, Content> biz;
	@RequestMapping("/contentadd.mc")
	public ModelAndView uadd() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "content/add");
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/insert.sh")
	public ModelAndView insert() {
		ModelAndView mv = new ModelAndView();
		Naver nv =new Naver();
		ArrayList<String> b=new ArrayList<String> ();
		b= nv.movieinsert("2015","2016");
		Content c=nv.details(b.get(0));
		System.out.println(c);
		try {
			System.out.println(biz);
			biz.insert(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("center", "register");
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/contentaddimpl.mc")
	public ModelAndView uaddc(ModelAndView mv, Content u) {
		try {
			biz.insert(u);

		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/contentlist.mc")
	public ModelAndView ulist() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Content> list = null;
		try {
			list = biz.select();
		} catch (Exception e) {
			e.printStackTrace();
		}

		mv.addObject("center", "content/list");
		mv.addObject("ulist", list);
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/contentdetail.mc")
	public ModelAndView pdetail(ModelAndView mv, Integer id) {
		Content p = null;
		try {
			p = biz.select(id);
			mv.addObject("ud", p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("navi", Navi.productlist);
		mv.addObject("center", "content/detail");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/contentdelete.mc")
	public String pdel(ModelAndView mv, Integer id) {
		try {
			biz.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:contentlist.mc";
	}
	@RequestMapping("/contentupdate.mc")
	public ModelAndView pup(ModelAndView mv, Integer id) {
		Content u = null;
		try {
			u = biz.select(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("navi", Navi.productlist);
		mv.addObject("uu",u);
		mv.addObject("center", "content/update");
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/contentupdateimpl.mc")
	public String pupimp(ModelAndView mv, Content p) {		
		try {
			biz.update(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:contentdetail.mc?id="+p.getId();
	}

}
