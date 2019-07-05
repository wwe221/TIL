package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Services;
import com.vo.Product;
import com.vo.User;

@Controller
public class ProductController {
	@Resource(name = "pbiz")
	Services<Integer, Product> biz;

	@RequestMapping("/productadd.mc")
	public ModelAndView padd() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "product/add");
		mv.addObject("navi", Navi.productadd);
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/productaddimpl.mc")
	public String paddc(ModelAndView mv, Product p) {
		String imgname = p.getMf().getOriginalFilename();
		p.setImgname(imgname);		
		try {			
			biz.insert(p);
			Util.saveFile(p.getMf());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:productlist.mc";
	}

	@RequestMapping("/productlist.mc")
	public ModelAndView plist() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Product> list = null;
		try {
			list = biz.select();

		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("plist", list);
		mv.addObject("navi", Navi.productlist);
		mv.addObject("center", "product/list");
		mv.setViewName("main");
		return mv;
	}


	@RequestMapping("/productdetail.mc")
	public ModelAndView pdetail(ModelAndView mv, int id) {
		Product p = null;
		try {
			p = biz.select(id);
			mv.addObject("pd", p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("navi", Navi.productlist);
		mv.addObject("center", "product/detail");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/productdelete.mc")
	public String pdel(ModelAndView mv, int id) {
		try {
			biz.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:productlist.mc";
	}
	@RequestMapping("/productupdate.mc")
	public ModelAndView pup(ModelAndView mv, int id) {
		Product u = null;
		try {
			u = biz.select(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("navi", Navi.productlist);
		mv.addObject("pu",u);
		mv.addObject("center", "product/update");
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/productupdateimpl.mc")
	public String pupimp(ModelAndView mv, Product p) {
		String imgname = p.getMf().getOriginalFilename();
		String ogimg = p.imgname;
		System.out.println(imgname);
		if(imgname==null || imgname.equals(""))
			p.setImgname(ogimg);			
		else
			p.setImgname(imgname);
		try {
			biz.update(p);
			Util.saveFile(p.getMf());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:productdetail.mc?id="+p.getId();
	}
}
