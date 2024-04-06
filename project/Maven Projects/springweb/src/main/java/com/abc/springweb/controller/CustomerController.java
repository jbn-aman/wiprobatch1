package com.abc.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.abc.springweb.model.Customer;

@Controller
public class CustomerController {

	@RequestMapping("/form")
	public ModelAndView getCustomerRegForm() {
				
		return new ModelAndView ("customerform","mycustomer",new Customer());
		
	}
	
	@RequestMapping(value="/register", method= RequestMethod.POST)
	public String registerCustomer(@ModelAttribute("mycustomer") Customer customer,Model model) {
		
		String msg = "Registration Success";
		model.addAttribute("msg", msg);
		return "customer-success";
	}
	
	@RequestMapping("/customer")
	public String displayCustomer(Model model) {

		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setFirstName("Aman");
		customer.setLastName("Yadav");
		customer.setAge(22);
		customer.setEmail("prakashaman5@gmail.com");

		model.addAttribute("mycustomer", customer);
		return "customer-details";
	}
}
