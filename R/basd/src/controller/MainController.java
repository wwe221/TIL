package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@RequestMapping("/main.m")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "main");
		mv.setViewName("main");
		return mv;
	}
}
