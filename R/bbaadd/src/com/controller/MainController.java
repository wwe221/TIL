package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
	@RequestMapping("/main.sh")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "main");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/highC.sh")
	public ModelAndView highCharts() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "highC");
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/Rcon1.sh")//
	@ResponseBody
	public void maplist(HttpServletResponse hsr) throws Exception {
		RConnection rc = new RConnection("70.12.114.58");
		System.out.println("Connection OK");
		rc.setStringEncoding("utf8");
		rc.eval(" source('C:/rstudio/r3/heath.R', encoding = 'UTF-8', echo=TRUE)");
		REXP rx2 = rc.eval("cole()");
		RList rlist = rx2.asList();
		double id[] = rlist.at("weight").asDoubles();
		double pwd[] = rlist.at("coles").asDoubles();
		JSONArray ja = new JSONArray();
		for (int i = 0; i < id.length; i++){
			JSONObject jo = new JSONObject();
			jo.put("ID", id[i]);
			jo.put("pwd", pwd[i]);
			ja.add(jo);
		}
		rc.close();
		PrintWriter out = null;
		try {
			hsr.setCharacterEncoding("EUC-KR");
			hsr.setContentType("text/json;charset=UTF-8");
			out = hsr.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//데이터 1차 가공 id = weight, pwd = 콜레스테롤로 가정
		String WeightArray = "[";
		String colesterolArray = "[";
		for(int i=0;i<id.length;i++) {
			WeightArray += "'"+id[i]+"', ";
			colesterolArray += "'" +pwd[i]+"',";
		}
		WeightArray = WeightArray.substring(0, WeightArray.length()-1);
		colesterolArray = colesterolArray.substring(0,colesterolArray.length()-1);
		WeightArray+="]";
		colesterolArray+="]";
		JSONObject jsO = new JSONObject();
		jsO.put("weight", WeightArray);
		jsO.put("colesterol",colesterolArray);
		out.print(jsO);
		}
}
