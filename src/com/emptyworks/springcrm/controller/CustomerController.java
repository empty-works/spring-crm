package com.emptyworks.springcrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emptyworks.springcrm.entity.Customer;
import com.emptyworks.springcrm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// Need to inject our customer service
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(path="/list", method=RequestMethod.GET)
	// Remember: can also use @GetMapping("/list") instead!!!!
	public String listCustomers(Model theModel) {
		
		// Get customers for the service 
		List<Customer> theCustomers = customerService.getCustomers();
		
		// Add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
}
