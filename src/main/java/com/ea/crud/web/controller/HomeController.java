package com.ea.crud.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	/*
	 * This controller will only work, if the Spring MVC settings are set
	 * completely and correctly (just as a hint).
	 */

	@RequestMapping("/")
	public ModelAndView showWelcome() {
		System.err.println("never entered here!!!!");
		return new ModelAndView("home");
	}
	
	@RequestMapping("/home")
	public ModelAndView indexPage() {
		System.err.println("never entered here!!!!");
		return new ModelAndView("home");
	}

}
