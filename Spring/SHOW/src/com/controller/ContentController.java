package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.biz.ContentBiz;
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
		ArrayList<Content> c=new ArrayList<> ();
		b= nv.movieinsert(2015,2017);
		int l = b.size();
		for(int i=0;i<l;i++) {
			if(nv.details(b.get(i)).getGenre().equals("성인물(에로)")) {
				continue;
			}
			c.add(nv.details(b.get(i)));
			
		}
		try {
			while(!c.isEmpty()) {
				biz.insert(c.remove(0));
			}			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("center", "register");
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/insert2.sh")
	public ModelAndView insert2() {
		ModelAndView mv = new ModelAndView();
		Naver nv =new Naver();
		
		ArrayList<Content> c=new ArrayList<> ();		
		c= Naver.test();
		try {
			while(!c.isEmpty()) {
				biz.insert(c.remove(0));
			}			
			
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
	@RequestMapping("/movielist.sh")
	public ModelAndView ulist() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Content> list = null;
		try {
			list = biz.select2(1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		mv.addObject("center", "movielist");
		mv.addObject("clist", list);
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/pelist.sh")
	public ModelAndView pelist() {
		ModelAndView mv = new ModelAndView();		
		ArrayList<Content> list = null;
		try {
			list = biz.select2(2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		mv.addObject("center", "pelist");
		mv.addObject("clist", list);
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
}
