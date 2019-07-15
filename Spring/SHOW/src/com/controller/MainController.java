package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.Post;
import com.vo.User;

@Controller
public class MainController {
	@Resource(name = "ubiz")
	Biz<String, User> biz;
	@Resource(name = "pbiz")
	Biz<Integer, Post> pbiz;
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
	
	@RequestMapping("/loginimpl.sh")
	public ModelAndView loginimpl(ModelAndView mv, HttpServletRequest request, HttpSession session) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		try {
			User dbuser = biz.select(id);
			if(pwd.equals(dbuser.getPwd())) {
			session.setAttribute("loginuser", dbuser);
				mv.setViewName("main");
			}else {
				mv.setViewName("loginfail");
			}
		} catch (Exception e) {
			mv.setViewName("loginfail");
			
			mv.addObject("center","loginfail");
			e.printStackTrace();
		}
		
		return mv;
	}

	@RequestMapping(value = "logout.sh", method = RequestMethod.GET)
    //메소드 이름은 LOGOUT 매게 변수는 SESSION
    public String logout(HttpSession session) {
        //m으로 선언된 세션을 삭제시킨다.
        session.removeAttribute("loginuser");
        // /페이지로 리다이렉트 시킨다.
        return "redirect:main.sh";
    }
	@RequestMapping("/movie.sh")
	public ModelAndView movie() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Post> list = null;
		try {
			list = pbiz.select();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("plist", list);
		mv.addObject("center", "movie");
		mv.addObject("navi", Navi.login);
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/pe.sh")
	public ModelAndView pe() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Post> list = null;
		try {
			list = pbiz.select();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("plist", list);
		mv.addObject("center", "pe");
		mv.addObject("navi", Navi.login);
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/music.sh")
	public ModelAndView music() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Post> list = null;
		try {
			list = pbiz.select();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("plist", list);
		mv.addObject("center", "music");
		mv.addObject("navi", Navi.login);
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/drama.sh")
	public ModelAndView drama() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Post> list = null;
		try {
			list = pbiz.select();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("plist", list);
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
