package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.Content;
import com.vo.Post;
import com.vo.User;

@Controller
@Aspect
public class MainController {
	private Logger work_log = 
			Logger.getLogger("work"); 
	private Logger user_log = 
			Logger.getLogger("user"); 
	private Logger data_log = 
			Logger.getLogger("data");
	
	@Resource(name = "ubiz")
	Biz<String, User> biz;

	@Resource(name = "pbiz")
	Biz<Integer, Post> pbiz;

	@Resource(name = "cbiz")
	Biz<Integer, Content> cbiz;

	@Before("execution(* com.controller..*Controller.*(..))")
	public void logging(JoinPoint jp) {		
		work_log.debug(jp.getSignature().getName());
		user_log.debug(jp.getSignature().getName());
		
	}
	@RequestMapping("/main.sh")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Post> list = null;
		ArrayList<Post> mvlist = new ArrayList<>();
		ArrayList<Post> pelist = new ArrayList<>();
		ArrayList<Post> mulist = new ArrayList<>();
		ArrayList<Post> dralist = new ArrayList<>();
		ArrayList<Content> content = null;
		
		try {
			list = pbiz.select();
			content = cbiz.select();
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean flag = false;
		while (!flag) {
			if (mvlist.size() == pelist.size() && mulist.size() == pelist.size() && pelist.size() == dralist.size()
					&& mvlist.size() == 5 || list.isEmpty()) {
				flag = true;
				break;
			}
			if (list.get(0).getCategory() == 1) {
				if (mvlist.size() <= 5) {
					mvlist.add(list.remove(0));
				}
			} else if(list.get(0).getCategory() == 2) {
				if (pelist.size() <= 5) {
					pelist.add(list.remove(0));
				}
			} else if(list.get(0).getCategory() == 3) {
				if (mulist.size() <= 5) {
					mulist.add(list.remove(0));
				}
			} else if(list.get(0).getCategory() == 4) {
				if (dralist.size() <= 5) {
					dralist.add(list.remove(0));
				}
			}else {
				list.remove(0);
			}
		}
		mv.addObject("mvlist", mvlist);
		mv.addObject("pelist", pelist);
		mv.addObject("mulist", mulist);
		mv.addObject("dralist", dralist);
		mv.addObject("cont", content);
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/login.sh")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "login");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/loginimpl.sh")
	public ModelAndView loginimpl(ModelAndView mv, HttpServletRequest request, HttpSession session) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		try {
			User dbuser = biz.select(id);
			if (pwd.equals(dbuser.getPwd())) {
				session.setAttribute("loginuser", dbuser);
				mv.setViewName("main");
			} else {
				mv.setViewName("loginfail");
			}
		} catch (Exception e) {
			mv.setViewName("loginfail");

			mv.addObject("center", "loginfail");
			e.printStackTrace();
		}

		return mv;
	}

	@RequestMapping(value = "logout.sh", method = RequestMethod.GET)
	// 메소드 이름은 LOGOUT 매게 변수는 SESSION
	public String logout(HttpSession session) {
		// m으로 선언된 세션을 삭제시킨다.
		session.removeAttribute("loginuser");
		// /페이지로 리다이렉트 시킨다.
		return "redirect:main.sh";
	}

	@RequestMapping("/movie.sh")
	public ModelAndView movie() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Post> list = null;
		ArrayList<Content> clist = new ArrayList<>();
		try {
			list = pbiz.select();
			for (int i = 0; i < list.size(); i++) {
				clist.add(cbiz.select(list.get(i).getContents()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("clist", clist);
		mv.addObject("plist", list);
		mv.addObject("center", "movie");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/pe.sh")
	public ModelAndView pe() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Post> list = null;
		ArrayList<Content> clist = new ArrayList<>();
		try {
			list = pbiz.select();
			for (int i = 0; i < list.size(); i++) {
				clist.add(cbiz.select(list.get(i).getContents()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("clist", clist);
		mv.addObject("plist", list);
		mv.addObject("center", "pe");
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
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/write.sh")
	public ModelAndView write() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "addreview");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/mypage.sh")
	public ModelAndView mypage(String id) {
		ModelAndView mv = new ModelAndView();
		User user = null;
		ArrayList<Post> list = null;
		System.out.println(id);
		try {
			user = biz.select(id);
			list = pbiz.select();

		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("u", user); 
		mv.addObject("mplist", list);
		mv.addObject("center", "mypage");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/adminmode.sh")
	public ModelAndView adminmode() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "admin/adminmode");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/usermgnt.sh")
	public ModelAndView usermgnt() {
		ModelAndView mv = new ModelAndView();
		ArrayList<User> list = null;

		try {
			list = biz.select();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("ulist", list);
		mv.addObject("center", "admin/usermgnt");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/postmgnt.sh")
	public ModelAndView postmgnt() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Post> list = null;

		try {
			list = pbiz.select();
		} catch (Exception e) {
			e.printStackTrace();
		}

		mv.addObject("plist", list);
		mv.addObject("center", "admin/postmgnt");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/userpostmgnt.sh")
	public ModelAndView userpostmgnt(String id) {
		ModelAndView mv = new ModelAndView();
		ArrayList<Post> list = null;
		try {
			list = pbiz.select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("uid", id);
		mv.addObject("mplist", list);
		mv.addObject("center", "admin/userpostmgnt");
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/404.sh")
	public ModelAndView notfound() {
		ModelAndView mv = new ModelAndView();		
		mv.addObject("center", "404");
		mv.setViewName("main");
		return mv;
	}
	
}
