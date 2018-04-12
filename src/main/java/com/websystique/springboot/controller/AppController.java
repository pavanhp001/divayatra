package com.websystique.springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@RequestMapping("/hotelAdmin")
	String hotelAdmin(HttpServletRequest request, ModelMap modal) {
		System.out.println("hotelAdmin = ");
		modal.addAttribute("title","Hotel Admin System");
		String contextPath = request.getContextPath();
		System.out.println("contextPath = "+contextPath);
		modal.addAttribute("contextPath",contextPath);
		return "index";
	}
	
	@RequestMapping("/")
	String home(HttpServletRequest request, ModelMap modal) {
		modal.addAttribute("title","Yathri");
		System.out.println("home = ");
		String contextPath = request.getContextPath();
		System.out.println("contextPath = "+contextPath);
		modal.addAttribute("contextPath",contextPath);
		
		return "homePage";
	}

	@RequestMapping("/partials/{page}")
	String partialHandler(@PathVariable("page") final String page) {
		System.out.println("partials = "+page);
		return page;
	}
	
	/*@RequestMapping("/hotelAdmin/partials/{page}")
	String hotelAdminHandler(@PathVariable("page") final String page) {
		System.out.println("hotelAdmin = "+page);
		return page;
	}*/

}
