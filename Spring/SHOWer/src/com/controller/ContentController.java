package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
		mv.addObject("center", "content/detail");
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/maplist.sh")
	@ResponseBody
	public void maplist(HttpServletResponse hsr) {

	ArrayList<Content> list = null;
	try {
	list = biz.select2(2);

	} catch (Exception e) {
	e.printStackTrace();
	}
	JSONArray ja =new JSONArray();
	for(Content c :list) {	
	JSONObject jo = new JSONObject();
	jo.put("place",c.getPlace());	
	jo.put("x",c.getLocx());
	jo.put("y",c.getLocy());
	ja.add(jo);
	}

	PrintWriter out = null;

	try {
	hsr.setCharacterEncoding("EUC-KR");
	hsr.setContentType("text/json;charset=UTF-8");
	out = hsr.getWriter();
	} catch (IOException e) {
	e.printStackTrace();
	}

	out.print(ja.toJSONString());
	}

}
