package com.abc.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String sayHello() {

		return "greetings";
	}

	@RequestMapping("/home")
	public String handle(Model model) {
		String data = "Employee Details";// model data
		model.addAttribute("mydata", data);
		return "home-page";

	}
}