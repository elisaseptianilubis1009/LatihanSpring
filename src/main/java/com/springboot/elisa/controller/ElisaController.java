package com.springboot.elisa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;

@Controller
public class ElisaController {
	// @RequestMapping ("/login")
	// public String home () {
	// 	return "login";
	// }

	@RequestMapping ("/")
	public String index () {
		return "Employee";
	}
	
	@RequestMapping ("/layout")
	public String home1 () {
		return "list2";
	}

	

	/*@equestMapping (value="/coba", method = RequestMethod.GET)
	public ModelAndView coba() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home.html");
		return modelAndView;
	}*/
	

	
}
