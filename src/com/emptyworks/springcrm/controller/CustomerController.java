package com.emptyworks.springcrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping(path="/showFormForAdd", method=RequestMethod.GET)
	public String showFormForAdd(Model theModel) {
		
		// Create model attribute to bind form data
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	@RequestMapping(path="/saveCustomer", method=RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// Save the customer using our service
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
}
