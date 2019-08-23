package com.controller;

import java.util.ArrayList;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
	@RequestMapping("/main.sh")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "center");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/first.sh")
	public ModelAndView first() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "first");
		try {
			ArrayList<String> list = maplist();
			mv.addObject("weight",list.get(0));
			mv.addObject("cole",list.get(1));	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/second.sh")
	public ModelAndView second() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "bb");
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/third.sh")
	public ModelAndView third() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "third");
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/Rcon2.sh")
	public void map() throws Exception {
		RConnection rc = new RConnection("70.12.114.194");
		System.out.println("Connection OK");
		rc.eval("source('/home/centos/R/heath.R', encoding = 'UTF-8', echo=TRUE)");
		REXP rx2 = rc.eval("keys()");
		RList rlist = rx2.asList();
		rc.close();
		
	}
	public ArrayList<String> maplist() throws Exception {
		RConnection rc = new RConnection("70.12.114.194");
		System.out.println("Connection OK");
		rc.setStringEncoding("utf8");
		rc.eval(" source('/home/centos/R/heath.R', encoding = 'UTF-8', echo=TRUE)");
		REXP rx2 = rc.eval("cole()");
		RList rlist = rx2.asList();
		String id[] = rlist.at("weight").asStrings();
		String pwd[] = rlist.at("coles").asStrings();
		
		
		//데이터 1차 가공 id = weight, pwd = 콜레스테롤로 가정
		String WeightArray = "[";
		String colesterolArray = "[";
		for(int i=0;i<id.length;i++) {
			WeightArray += "'"+id[i]+"', ";
			colesterolArray += "'" +pwd[i]+"', ";
		}
		
		WeightArray = WeightArray.substring(0, WeightArray.length()-2);
		colesterolArray = colesterolArray.substring(0,colesterolArray.length()-2);
		WeightArray+="]";
		colesterolArray+="]";
		ArrayList<String> list = new ArrayList<String>();
		list.add(WeightArray);
		list.add(colesterolArray);
		return list;
		}
}
