package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.Content;
import com.vo.Post;
import com.vo.Star;

@Controller
public class PostController {
	@Resource(name = "pbiz")
	Biz<Integer, Post> pbiz;

	@Resource(name = "sbiz")
	Biz<Integer, Star> sbiz;

	@Resource(name = "cbiz")
	Biz<Integer, Content> cbiz;
	
	// PostAdd
	@RequestMapping("/postadd.sh")
	public ModelAndView postadd(String id) {
		ModelAndView mv = new ModelAndView();
		System.out.println(id);
		mv.addObject("center", "post/add");
		mv.setViewName("main");
		return mv;
	}

	// PostCommentAdd
	@RequestMapping("/postcommentadd.sh")
	public String postcommentadd(Post post) {
		// 댓글 작성
		int cat = post.getReid();
		System.out.println(post);
		post.setImg1("1");
		post.setImg2("1");
		post.setImg3("1");
		try {
			pbiz.insert(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String nav = getNav(post.getCategory());
		return "redirect:" + "postdetail" + ".sh?id=" + cat;
	}

	// MoviePost
	@RequestMapping(value = "/postadd2.sh", method = RequestMethod.POST)
	public ModelAndView postaddmv(int id, String title, int category) {
		// 영화 post 작성
		System.out.println(id);
		System.out.println(title);
		System.out.println(category);
		ModelAndView mv = new ModelAndView();
		mv.addObject("contentId", id);
		mv.addObject("contentTitle", title);
		mv.addObject("category", category);
		mv.addObject("center", "post/add");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/postaddimpl.sh")
	public String postaddimpl(ModelAndView mv, Post post, String nav) {		
		String imgname1 = "";
		String imgname2 = "";
		String imgname3 = "";
		int cat =post.getCate();
		System.out.println(post);
		try {
			if (post.getMf1() != null && cat==1 || cat == 2) {
				imgname1 = post.getMf1().getOriginalFilename();
				imgname2 = post.getMf2().getOriginalFilename();
				imgname3 = post.getMf3().getOriginalFilename();
			
			if (imgname1.equals("")) {
				post.setImg1("1");
			} else {
				post.setImg1(imgname1);
			}
			if (imgname2.equals("")) {
				post.setImg2("1");
			} else {
				post.setImg2(imgname2);
			}
			if (imgname3.equals("")) {
				post.setImg3("1");
			} else {
				post.setImg3(imgname3);
			}
			}
			System.out.println(post);
			pbiz.insert(post);
			if (!imgname1.equals(""))
				Util.saveFile(post.getMf1());
			if (!imgname2.equals(""))
				Util.saveFile(post.getMf2());
			if (!imgname3.equals(""))
				Util.saveFile(post.getMf3());
			int cate = post.getCategory();
			switch (cate) {
			case 1: {
				nav = "movie";
				break;
			}
			case 2: {
				nav = "pe";
				break;
			}
			case 3: {
				nav = "music";
				break;
			}
			case 4: {
				nav = "drama";
				break;
			}
			default: {
				nav = "main";
			}
			}
			mv.addObject("center", nav);
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("center", "post/testfail");
		}
		return "redirect:" + nav + ".sh";
	}


	// PostDetail : 게시글 하나 선택
	// 게시판 내 게시글 리스트에서 글 제목 클릭하면 여기로 이동하도록 설정해야됨
	@RequestMapping("/postdetail.sh")
	public ModelAndView postdetail(ModelAndView mv, String id) {
		// DATA는 String 형태로 주고 받으므로, String 형태로 받은 후 int로 변환
		Post post = null;
		Star star = null;
		Content cont = null;
		ArrayList<Post> comments = null;
		int iid = Integer.parseInt(id);
		try {
			post = pbiz.select(iid);
			cont = cbiz.select(post.getContents());
			star = sbiz.select(iid); // 평점정보가져옴?
			comments = pbiz.select2(iid);
			mv.addObject("postdetail", post); // 해당하는 id에서 select한 값을 postdetail에 저장 → view에서 불러올 때 사용
			mv.addObject("stardetail", star);
			mv.addObject("contdetail", cont);
			mv.addObject("comments", comments);

			mv.addObject("center", "post/detail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("main");
		return mv;
	}

	// PostDelete
	@RequestMapping("/postdelete.sh")
	public String postdelete(ModelAndView mv, String id,String cate) {
		int cat = Integer.parseInt(cate);
		String nav = getNav(cat);
		Post post= null;
		try {
			post = pbiz.select(Integer.parseInt(id));			
			pbiz.delete(Integer.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(cat==99) {			
			return "redirect:" + "postdetail" + ".sh?id="+post.getReid();
		}
		return "redirect:" + nav + ".sh";
	}

	// PostUpdate
	@RequestMapping("/postupdate.sh")
	public ModelAndView postupdate(ModelAndView mv, String id) {
		Post post = null;
		Star star = null;
		Content cont = null;
		try {
			post = pbiz.select(Integer.parseInt(id));
			star = sbiz.select(Integer.parseInt(id));
			cont = cbiz.select(post.getContents());
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("content", cont);
		mv.addObject("postupdate", post);
		mv.addObject("center", "post/update");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/postupdateimpl.sh")
	public String postupdateimp(ModelAndView mv, Post post) {
		System.out.println(post);
		int cat = post.getCategory();
		try {
			pbiz.update(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (cat == 99) {
			return "redirect:" + "postdetail" + ".sh?id=" + post.getReid();
		}
		return "redirect:postdetail.sh?id=" + post.getId();
	}

	public String getNav(int cate) {
		String nav = "";
		switch (cate) {
		case 1: {
			nav = "movie";
			break;
		}
		case 2: {
			nav = "pe";
			break;
		}
		case 3: {
			nav = "music";
			break;
		}
		case 4: {
			nav = "drama";
			break;
		}
		case 77:{
			nav="postmgnt";
			break;
		}
		default: {
			nav = "main";
		}
		}
		return nav;
	}
}
