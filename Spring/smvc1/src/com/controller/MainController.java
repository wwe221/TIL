package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
public class MainController {
	@RequestMapping("/main.mc")// main.mc가 요청되면 실행된다
	public ModelAndView main() {
		//데이터와 화면
		//모델 앤드 뷰 
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");		
		return mv;
		//modelandview 를 return 하면  자동으로 forward 가 된다
	}
}
