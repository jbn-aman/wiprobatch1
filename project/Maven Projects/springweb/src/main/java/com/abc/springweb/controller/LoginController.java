package com.abc.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping(value="/loginform",method = RequestMethod.GET)
	public String getLoginform() {
		return "login-form";
	}
	
	@RequestMapping("/login")
	public String loginProcess(@RequestParam("uname") String name,@RequestParam("upwd") String pwd, Model model) {
		if(pwd.equals("1234")) {			
			String msg = "Welcome"+name;			
			model.addAttribute("message",msg);			
			return "login-success";
		}
		else {
			String msg = "Hello "+name+" You entered invalid password";			
			model.addAttribute("message",msg);			
			return "login-failure";
		}
	}
	

}
